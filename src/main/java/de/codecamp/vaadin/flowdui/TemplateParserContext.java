package de.codecamp.vaadin.flowdui;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.StreamSupport;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.components.Slot;


/**
 * Gathers the state while parsing a template and provides methods to parse attributes and child
 * components.
 */
public class TemplateParserContext
{

  public static final String CUSTOM_ATTR_PREFIX = "";

  public static final String CUSTOM_LAYOUT_ATTR_PREFIX = "";


  private static final Logger LOG = LoggerFactory.getLogger(TemplateParserContext.class);


  private final List<ComponentFactory> factories;

  private final List<ComponentPostProcessor> processors;


  private String templateId;


  private Component rootComponent;

  private Map<String, Component> idToComponent = new HashMap<>();

  private Map<String, Slot> nameToSlot = new HashMap<>();

  private Map<String, Element> idToTemplateFragment = new HashMap<>();


  public TemplateParserContext(String templateId, List<ComponentFactory> factories,
      List<ComponentPostProcessor> processors)
  {
    this.templateId = templateId;
    this.factories = factories;
    this.processors = processors;
  }


  public void parseTemplate(Document templateDocument)
  {
    Element body = templateDocument.body();

    AtomicBoolean hasNonBlankTextNodes = new AtomicBoolean(false);
    doReadChildren(null, body, (slotName, childElement) -> {
      if (slotName != null)
        return false;

      if (getRootComponent() != null)
      {
        String msg = "The template '%s' must have exactly one single single root component, but"
            + " found more than one.";
        msg = String.format(msg, getTemplateId());
        throw new TemplateException(msg);
      }

      setRootComponent(readComponent(childElement, null));
      return true;
    }, textNode -> {
      hasNonBlankTextNodes.set(true);
    });

    if (getRootComponent() == null)
    {
      String msg =
          "The template '%s' must have exactly one single root component, but found" + " none.";
      msg = String.format(msg, getTemplateId());
      throw new TemplateException(msg);
    }

    if (hasNonBlankTextNodes.get())
    {
      LOG.warn("The template '{}' contains text around its root component that will be ignored.",
          getTemplateId());
    }
  }

  public void parseTemplateFragment(Element fragmentElement)
  {
    doReadChildren(null, fragmentElement, (slotName, childElement) -> {
      if (slotName != null)
        return false;

      if (getRootComponent() != null)
        throw new TemplateException("The template fragment must have a single root element.");

      setRootComponent(readComponent(childElement, null));
      return true;
    }, null);
  }


  /**
   * Creates a component based on the given HTML element.
   *
   * @param element
   *          the HTML to create the component from
   * @param consumedAttributes
   *          the set of attributes of the element that have already been consumed to configure the
   *          component; additional consumed attributes will be added to the set; may be null
   * @return the new component
   */
  public Component readComponent(Element element, Set<String> consumedAttributes)
  {
    Component component = null;

    if (consumedAttributes == null)
      consumedAttributes = new HashSet<>();

    for (ComponentFactory f : factories)
    {
      component = f.createComponent(element, this, consumedAttributes);
      if (component != null)
        break;
    }
    if (component == null)
      throw new RuntimeException("Unknown element in template: " + element.tagName());


    for (ComponentPostProcessor p : processors)
    {
      p.postProcessComponent(component, element, this, consumedAttributes);
    }

    registerComponent(component);


    Set<String> leftOverAttributes = StreamSupport.stream(element.attributes().spliterator(), false)
        .map(Attribute::getKey).collect(toSet());
    leftOverAttributes.removeAll(consumedAttributes);

    if (!leftOverAttributes.isEmpty())
    {
      String msg = "Unused attributes found on '%s' element: %s\n%s";
      msg = String.format(msg, element.tagName(),
          leftOverAttributes.stream().collect(joining("', '", "'", "'")), element);
      LOG.error(msg);
    }

    return component;
  }

  /**
   * Creates a component based on the given HTML element. Same as
   * {@link #readComponent(Element, Set)} except that the slot-attribute is automatically marked as
   * consumed.
   *
   * @param element
   *          the element for which to create a component
   * @param consumedAttributes
   *          a set of attributes of the element that are already consumed; may be null
   * @return the created component
   */
  public Component readComponentForSlot(Element element, Set<String> consumedAttributes)
  {
    if (consumedAttributes == null)
      consumedAttributes = new HashSet<>();
    consumedAttributes.add("slot");
    return readComponent(element, consumedAttributes);
  }


  /**
   * Reads the children of of the given component.
   *
   * @param parentComponent
   *          the parent component
   * @param parentElement
   *          the HTML element of the parent component
   * @param childComponentHandler
   *          a child component handler; may be null
   * @param textNodeHandler
   *          a text node handler; may be null
   */
  public void readChildren(Component parentComponent, Element parentElement,
      ChildComponentHandler childComponentHandler, TextNodeHandler textNodeHandler)
  {
    Objects.requireNonNull(parentComponent, "parentComponent must not be null");

    doReadChildren(parentComponent, parentElement, childComponentHandler, textNodeHandler);
  }

  private void doReadChildren(Component parentComponent, Element parentElement,
      ChildComponentHandler childComponentHandler, TextNodeHandler textNodeHandler)
  {
    Objects.requireNonNull(parentElement, "parentElement must not be null");

    Set<String> consumedSlot = new HashSet<>();

    for (Node node : parentElement.childNodes())
    {
      if (node instanceof Element)
      {
        Element childElement = (Element) node;

        if (childElement.tagName().equals("template") || childElement.tagName().equals("fragment"))
        {
          registerTemplateFragment(childElement);
          continue;
        }


        String slotName = null;
        if (childElement.hasAttr("slot"))
        {
          slotName = childElement.attr("slot");
          if (consumedSlot.contains(slotName))
          {
            String msg = "Slot '%s' already filled.";
            msg = String.format(msg, slotName);
            throw new TemplateException(parentElement, msg);
          }
        }

        boolean handled =
            childComponentHandler != null && childComponentHandler.handle(slotName, childElement);

        if (!handled && parentComponent != null)
        {
          for (ComponentPostProcessor processor : processors)
          {
            handled = processor.handleChildComponent(parentComponent, slotName, childElement, this);
            if (handled)
              break;
          }
        }

        if (!handled)
        {
          if (slotName != null)
          {
            throw new TemplateException(parentElement, "Unknown slot: " + slotName);
          }
          else
          {
            String msg = "Child element '%s' not supported here.";
            msg = String.format(msg, childElement.tagName());
            throw new TemplateException(parentElement, msg);
          }
        }
      }

      else if (node instanceof TextNode)
      {
        if (textNodeHandler != null)
          textNodeHandler.handle((TextNode) node);
        else if (!((TextNode) node).text().trim().isEmpty())
          throw new TemplateException(parentElement, "No child text supported.");
      }
    }
  }


  public <C> Boolean readBooleanAttribute(Element element, String attrName,
      Consumer<Boolean> setter, Set<String> consumedAttributes)
  {
    if (element.hasAttr(attrName))
    {
      setter.accept(true);

      if (consumedAttributes != null)
        consumedAttributes.add(attrName);

      return true;
    }
    else
    {
      return false;
    }
  }

  public <C> Integer readIntegerAttribute(Element element, String attrName,
      Consumer<Integer> setter, Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, Integer::parseInt, consumedAttributes);
  }

  public <C> Double readDoubleAttribute(Element element, String attrName, Consumer<Double> setter,
      Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, Double::parseDouble, consumedAttributes);
  }

  public <C> BigDecimal readBigDecimalAttribute(Element element, String attrName,
      Consumer<BigDecimal> setter, Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, BigDecimal::new, consumedAttributes);
  }

  public String readStringAttribute(Element element, String attrName, Consumer<String> setter,
      Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, v -> v, consumedAttributes);
  }

  public <E extends Enum<E>> E readEnumAttribute(Element element, String attrName,
      Function<String, E> enumResolver, Consumer<E> setter, Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, attrString -> {
      E enumValue = enumResolver.apply(attrString);
      if (enumValue == null)
        throw new IllegalArgumentException(
            "No enum constant for value '" + attrString + "' found.");
      return enumValue;
    }, consumedAttributes);
  }

  public LocalDate readLocalDateAttribute(Element element, String attrName,
      Consumer<LocalDate> setter, Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, v -> LocalDate.parse(v), consumedAttributes);
  }

  public LocalTime readLocalTimeAttribute(Element element, String attrName,
      Consumer<LocalTime> setter, Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, v -> LocalTime.parse(v), consumedAttributes);
  }

  public LocalDateTime readLocalDateTimeAttribute(Element element, String attrName,
      Consumer<LocalDateTime> setter, Set<String> consumedAttributes)
  {
    return readAttribute(element, attrName, setter, v -> LocalDateTime.parse(v),
        consumedAttributes);
  }

  <C, V> V readAttribute(Element element, String attrName, Consumer<V> setter,
      Function<String, V> parser, Set<String> consumedAttributes)
  {
    V value = null;
    if (element.hasAttr(attrName))
    {
      value = parser.apply(element.attr(attrName));

      if (setter != null)
        setter.accept(value);

      if (consumedAttributes != null)
        consumedAttributes.add(attrName);
    }
    return value;
  }

  public void copyAttribute(Element element, String attrName, Component component,
      Set<String> consumedAttributes)
  {
    readStringAttribute(element, attrName, v -> component.getElement().setAttribute(attrName, v),
        consumedAttributes);
  }

  /**
   * Copy all remaining unconsumed attributes as they are.
   *
   * @param element
   *          the source element
   * @param component
   *          the target component
   * @param consumedAttributes
   *          the consumed attributes
   */
  public void copyAttributes(Element element, Component component, Set<String> consumedAttributes)
  {
    for (Attribute attr : element.attributes())
    {
      if (consumedAttributes.contains(attr.getKey()))
        continue;

      if (element.hasAttr(attr.getKey()))
      {
        component.getElement().setAttribute(attr.getKey(), element.attr(attr.getKey()));

        if (consumedAttributes != null)
          consumedAttributes.add(attr.getKey());
      }
    }
  }



  public String getTemplateId()
  {
    return templateId;
  }

  public Component getRootComponent()
  {
    return rootComponent;
  }

  public void setRootComponent(Component rootComponent)
  {
    this.rootComponent = rootComponent;
  }

  public Map<String, Component> getComponentsById()
  {
    return idToComponent;
  }

  private void registerComponent(Component component)
  {
    component.getId().ifPresent(id -> {
      if (idToComponent.containsKey(id))
      {
        String msg = "The ID '%s' is already used.";
        msg = String.format(msg, id);
        throw new TemplateException(msg);
      }
      idToComponent.put(id, component);
    });

    if (component instanceof Slot)
    {
      Slot slot = (Slot) component;
      if (nameToSlot.containsKey(slot.getName()))
      {
        String msg = "The slot name '%s' is already used.";
        msg = String.format(msg, slot.getName());
        throw new TemplateException(msg);
      }

      nameToSlot.put(slot.getName(), slot);
    }
  }

  private void registerTemplateFragment(Element htmlTemplateElement)
  {
    String id = htmlTemplateElement.id();
    if (id.isEmpty())
      throw new TemplateException("The template fragment is missing an ID.");

    idToTemplateFragment.put(id, htmlTemplateElement);
  }

  public Map<String, Slot> getSlotsByName()
  {
    return nameToSlot;
  }

  public Map<String, Element> getTemplateFragmentById()
  {
    return idToTemplateFragment;
  }

}
