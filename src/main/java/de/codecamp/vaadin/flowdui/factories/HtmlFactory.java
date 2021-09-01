package de.codecamp.vaadin.flowdui.factories;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Article;
import com.vaadin.flow.component.html.Aside;
import com.vaadin.flow.component.html.DescriptionList;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Emphasis;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.html.IFrame.ImportanceType;
import com.vaadin.flow.component.html.IFrame.SandboxType;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.OrderedList.NumberingType;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Pre;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;
import de.codecamp.vaadin.flowdui.components.Bold;
import de.codecamp.vaadin.flowdui.components.Fieldset;
import de.codecamp.vaadin.flowdui.components.Strong;


public class HtmlFactory
  implements
    ComponentFactory
{

  private static final Map<String, NumberingType> NUMBERING_TYPE = new HashMap<>();
  static
  {
    NUMBERING_TYPE.put("1", NumberingType.NUMBER);
    NUMBERING_TYPE.put("A", NumberingType.UPPERCASE_LETTER);
    NUMBERING_TYPE.put("a", NumberingType.LOWERCASE_LETTER);
    NUMBERING_TYPE.put("I", NumberingType.UPPERCASE_ROMAN);
    NUMBERING_TYPE.put("i", NumberingType.LOWERCASE_ROMAN);
  }

  private static final Map<String, ImportanceType> IMPORTANCE_TYPE = new HashMap<>();
  static
  {
    for (ImportanceType importanceType : ImportanceType.values())
    {
      IMPORTANCE_TYPE.put(importanceType.getValue(), importanceType);
    }
  }

  private static final Map<String, SandboxType> SANDBOX_TYPE = new HashMap<>();
  static
  {
    for (SandboxType sandboxType : SandboxType.values())
    {
      SANDBOX_TYPE.put(sandboxType.getValue(), sandboxType);
    }
  }


  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    Component component;
    switch (element.tagName())
    {
      case Tag.A:
        Anchor anchor = new Anchor();
        context.readStringAttribute(element, "href", anchor::setHref, null);
        context.readStringAttribute(element, "target", anchor::setTarget, null);
        component = anchor;
        break;

      case Tag.ARTICLE:
        component = new Article();
        break;
      case Tag.ASIDE:
        component = new Aside();
        break;
      case "b":
        component = new Bold();
        break;
      case Tag.DL:
        component = new DescriptionList();
        break;
      case Tag.DT:
        component = new DescriptionList.Term();
        break;
      case Tag.DD:
        component = new DescriptionList.Description();
        break;
      case Tag.DIV:
        component = new Div();
        break;
      case Tag.EM:
        component = new Emphasis();
        break;
      case Tag.FOOTER:
        component = new Footer();
        break;
      case Tag.H1:
        component = new H1();
        break;
      case Tag.H2:
        component = new H2();
        break;
      case Tag.H3:
        component = new H3();
        break;
      case Tag.H4:
        component = new H4();
        break;
      case Tag.H5:
        component = new H5();
        break;
      case Tag.H6:
        component = new H6();
        break;
      case Tag.HEADER:
        component = new Header();
        break;
      case Tag.HR:
        component = new Hr();
        break;
      case Tag.IFRAME:
        IFrame iFrame = new IFrame();
        context.readStringAttribute(element, "src", iFrame::setSrc, consumedAttributes);
        context.readStringAttribute(element, "srcdoc", iFrame::setSrcdoc, consumedAttributes);
        context.readStringAttribute(element, "name", iFrame::setName, consumedAttributes);
        context.readStringAttribute(element, "allow", iFrame::setAllow, consumedAttributes);
        context.readEnumAttribute(element, "importance", IMPORTANCE_TYPE::get,
            iFrame::setImportance, consumedAttributes);
        context.readEnumAttribute(element, "sandbox", SANDBOX_TYPE::get, iFrame::setSandbox,
            consumedAttributes);
        component = iFrame;
        break;
      case Tag.IMG:
        Image image = new Image();
        context.readStringAttribute(element, "src", image::setSrc, consumedAttributes);
        context.readStringAttribute(element, "alt", image::setAlt, consumedAttributes);
        component = image;
        break;
      case Tag.INPUT:
        Input input = new Input();
        context.readStringAttribute(element, "placeholder", input::setPlaceholder,
            consumedAttributes);
        context.readStringAttribute(element, "type", input::setType, consumedAttributes);
        component = input;
        break;
      case Tag.LABEL:
        Label label = new Label();
        context.readStringAttribute(element, "for", label::setFor, consumedAttributes);
        component = label;
        break;
      case Tag.LI:
        component = new ListItem();
        break;
      case Tag.MAIN:
        component = new Main();
        break;
      case Tag.BUTTON:
        component = new NativeButton();
        break;
      case Tag.NAV:
        component = new Nav();
        break;
      case Tag.OL:
        OrderedList orderedList = new OrderedList();
        context.readEnumAttribute(element, "type", NUMBERING_TYPE::get, orderedList::setType,
            consumedAttributes);
        component = orderedList;
        break;
      case Tag.P:
        component = new Paragraph();
        break;
      case Tag.PRE:
        component = new Pre();
        break;
      case Tag.SECTION:
        component = new Section();
        break;
      case Tag.SPAN:
        component = new Span();
        break;
      case Tag.STRONG:
        component = new Strong();
        break;
      case Tag.UL:
        component = new UnorderedList();
        break;

      case "fieldset":
        component = new Fieldset();
        break;

      default:
        component = null;
        break;
    }

    if (component instanceof HtmlComponent)
    {
      HtmlComponent htmlComponent = (HtmlComponent) component;
      context.readStringAttribute(element, "title", htmlComponent::setTitle, consumedAttributes);
    }

    if (component != null)
    {
      context.copyAttributes(element, component, consumedAttributes);
    }

    if (component instanceof HasComponents)
    {
      HasComponents hasComponents = (HasComponents) component;

      context.readChildren(component, element, (slotName, childElement) -> {
        hasComponents.add(context.readComponent(childElement, null));
        return true;
      }, textNode -> {
        hasComponents.add(textNode.text());
      });
    }
    else if (component != null)
    {
      context.readChildren(component, element, null, null);
    }

    return component;
  }

}
