package de.codecamp.vaadin.flowdui;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.StreamSupport;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.TemplateBuilder.SlotablesProvider;
import de.codecamp.vaadin.flowdui.components.Slot;


public class TemplateContext
{

  public static final String CUSTOM_ATTR_PREFIX = "";

  public static final String CUSTOM_LAYOUT_ATTR_PREFIX = "";


  private static final Logger LOG = LoggerFactory.getLogger(TemplateContext.class);


  private final List<ComponentFactory> factories;

  private final List<ComponentPostProcessor> processors;


  private Component rootComponent;

  private Map<String, Component> idToComponent = new HashMap<>();

  private SlotablesProvider slotablesProvider;

  private Map<String, Slot> slots = new HashMap<>();


  public TemplateContext(List<ComponentFactory> factories, List<ComponentPostProcessor> processors)
  {
    this.factories = factories;
    this.processors = processors;
  }


  public Component readComponentForSlot(Element element, Set<String> consumedAttributes)
  {
    if (consumedAttributes == null)
      consumedAttributes = new HashSet<>();
    consumedAttributes.add("slot");
    return readComponent(element, consumedAttributes);
  }

  public Component readComponent(Element element, Set<String> consumedAttributes)
  {
    ComponentFactory factory = null;
    Component component = null;

    if (consumedAttributes == null)
      consumedAttributes = new HashSet<>();

    for (ComponentFactory f : factories)
    {
      component = f.createComponent(element, this, consumedAttributes);
      if (component != null)
      {
        factory = f;
        break;
      }
    }
    if (component == null)
      throw new RuntimeException("Unknown element in design template: " + element.tagName());

    if (factory == null)
      throw new AssertionError();


    for (ComponentPostProcessor p : processors)
    {
      p.postProcessComponent(element, component, this, consumedAttributes);
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

  public void readChildren(Element element, BiPredicate<String, Element> childComponentHandler,
      Consumer<TextNode> textNodeHandler)
  {
    Set<String> consumedSlot = new HashSet<>();

    for (Node node : element.childNodes())
    {
      if (node instanceof Element)
      {
        Element childElement = (Element) node;

        if (childComponentHandler == null)
          throw new TemplateException(element, "No child elements supported.");

        if (childElement.hasAttr("slot"))
        {
          String slotName = childElement.attr("slot");
          if (consumedSlot.contains(slotName))
          {
            String msg = "Slot '%s' already filled.";
            msg = String.format(msg, slotName);
            throw new TemplateException(element, msg);
          }

          if (!childComponentHandler.test(slotName, childElement))
          {
            throw new TemplateException(element, "Unknown slot: " + slotName);
          }
        }
        else
        {
          if (!childComponentHandler.test(null, childElement))
          {

            String msg = "Child element '%s' not supported here.";
            msg = String.format(msg, childElement.tagName());
            throw new TemplateException(element, msg);
          }
        }
      }
      else if (node instanceof TextNode)
      {
        if (textNodeHandler != null)
          textNodeHandler.accept((TextNode) node);
        else if (!((TextNode) node).text().trim().isEmpty())
          throw new TemplateException(element, "No child text supported.");
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


  public Map<String, Component> getComponentsById()
  {
    return idToComponent;
  }

  public Component getRootComponent()
  {
    return rootComponent;
  }

  public void setRootComponent(Component rootComponent)
  {
    this.rootComponent = rootComponent;
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
      if (slots.containsKey(slot.getName()))
      {
        String msg = "The slot name '%s' is already used.";
        msg = String.format(msg, slot.getName());
        throw new TemplateException(msg);
      }

      slots.put(slot.getName(), slot);
    }
  }

  public void setSlotablesProvider(SlotablesProvider slotablesProvider)
  {
    this.slotablesProvider = slotablesProvider;
  }

  /**
   * Returns the slotables for the given slot name.
   *
   * @param slotName
   *          the slot name
   * @return the slotables for the given slot name; list may be empty, but never null
   */
  public List<Component> getSlotablesForSlot(String slotName)
  {
    if (slotablesProvider == null)
      return Collections.emptyList();
    return Optional.ofNullable(slotablesProvider.getSlotables(slotName))
        .orElse(Collections.emptyList());
  }

}
