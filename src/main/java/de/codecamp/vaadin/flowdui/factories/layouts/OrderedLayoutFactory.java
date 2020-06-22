package de.codecamp.vaadin.flowdui.factories.layouts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.Scroller.ScrollDirection;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParseContext;


public class OrderedLayoutFactory
  implements ComponentFactory, ComponentPostProcessor
{

  private static final Map<String, FlexComponent.Alignment> ALIGNMENT = new HashMap<>();
  static
  {
    ALIGNMENT.put("flex-start", FlexComponent.Alignment.START);
    ALIGNMENT.put("flex-end", FlexComponent.Alignment.END);
    ALIGNMENT.put("center", FlexComponent.Alignment.CENTER);
    ALIGNMENT.put("stretch", FlexComponent.Alignment.STRETCH);
    ALIGNMENT.put("baseline", FlexComponent.Alignment.BASELINE);
    ALIGNMENT.put("auto", FlexComponent.Alignment.AUTO);
  }

  private static final Map<String, FlexComponent.JustifyContentMode> JUSTIFY_CONTENT =
      new HashMap<>();
  static
  {
    JUSTIFY_CONTENT.put("flex-start", FlexComponent.JustifyContentMode.START);
    JUSTIFY_CONTENT.put("flex-end", FlexComponent.JustifyContentMode.END);
    JUSTIFY_CONTENT.put("center", FlexComponent.JustifyContentMode.CENTER);
    JUSTIFY_CONTENT.put("space-between", FlexComponent.JustifyContentMode.BETWEEN);
    JUSTIFY_CONTENT.put("space-around", FlexComponent.JustifyContentMode.AROUND);
    JUSTIFY_CONTENT.put("space-evenly", FlexComponent.JustifyContentMode.EVENLY);
  }

  private static final Map<String, FlexLayout.FlexWrap> FLEX_WRAP = new HashMap<>();
  static
  {
    FLEX_WRAP.put("nowrap", FlexLayout.FlexWrap.NOWRAP);
    FLEX_WRAP.put("wrap", FlexLayout.FlexWrap.WRAP);
    FLEX_WRAP.put("wrap-reverse", FlexLayout.FlexWrap.WRAP_REVERSE);
  }

  private static final Map<String, FlexLayout.FlexDirection> FLEX_DIRECTION = new HashMap<>();
  static
  {
    FLEX_DIRECTION.put("column", FlexLayout.FlexDirection.COLUMN);
    FLEX_DIRECTION.put("column-reverse", FlexLayout.FlexDirection.COLUMN_REVERSE);
    FLEX_DIRECTION.put("row", FlexLayout.FlexDirection.ROW);
    FLEX_DIRECTION.put("row-reverse", FlexLayout.FlexDirection.ROW_REVERSE);
  }

  private static final Map<String, FlexLayout.ContentAlignment> CONTENT_ALIGNMENT = new HashMap<>();
  static
  {
    CONTENT_ALIGNMENT.put("flex-start", FlexLayout.ContentAlignment.START);
    CONTENT_ALIGNMENT.put("flex-end", FlexLayout.ContentAlignment.END);
    CONTENT_ALIGNMENT.put("center", FlexLayout.ContentAlignment.CENTER);
    CONTENT_ALIGNMENT.put("stretch", FlexLayout.ContentAlignment.STRETCH);
    CONTENT_ALIGNMENT.put("space-between", FlexLayout.ContentAlignment.SPACE_BETWEEN);
    CONTENT_ALIGNMENT.put("space-around", FlexLayout.ContentAlignment.SPACE_AROUND);
  }

  private static final Map<String, BoxSizing> BOX_SIZING = new HashMap<>();
  static
  {
    BOX_SIZING.put("border-box", BoxSizing.BORDER_BOX);
    BOX_SIZING.put("content-box", BoxSizing.CONTENT_BOX);
  }

  private static final Map<String, ScrollDirection> SCROLL_DIRECTION = new HashMap<>();
  static
  {
    SCROLL_DIRECTION.put("both", Scroller.ScrollDirection.BOTH);
    SCROLL_DIRECTION.put("horizontal", Scroller.ScrollDirection.HORIZONTAL);
    SCROLL_DIRECTION.put("vertical", Scroller.ScrollDirection.VERTICAL);
    SCROLL_DIRECTION.put("none", Scroller.ScrollDirection.NONE);
  }


  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    Component component = null;
    switch (element.tagName())
    {
      case "vaadin-horizontal-layout":
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        // remove defaults that only exist in the Java API
        horizontalLayout.setSpacing(false);
        component = horizontalLayout;
        break;

      case "vaadin-vertical-layout":
        VerticalLayout verticalLayout = new VerticalLayout();
        // remove defaults that only exist in the Java API
        verticalLayout.setWidth(null);
        verticalLayout.setPadding(false);
        verticalLayout.setSpacing(false);
        component = verticalLayout;
        break;

      case "vaadin-scroller":
        Scroller scroller = new Scroller();
        context.readEnumAttribute(element, "scroll-direction", SCROLL_DIRECTION::get,
            scroller::setScrollDirection, consumedAttributes);
        component = scroller;
        break;

      case "vaadin-flex-layout":
        FlexLayout flexLayout = new FlexLayout();
        context.readEnumAttribute(element, "flex-wrap", FLEX_WRAP::get, flexLayout::setFlexWrap,
            consumedAttributes);
        context.readEnumAttribute(element, "flex-direction", FLEX_DIRECTION::get,
            flexLayout::setFlexDirection, consumedAttributes);
        context.readEnumAttribute(element, "align-content", CONTENT_ALIGNMENT::get,
            flexLayout::setAlignContent, consumedAttributes);
        component = flexLayout;
        break;
    }

    if (component instanceof FlexComponent)
    {
      FlexComponent<?> flexComponent = (FlexComponent<?>) component;

      context.readChildren(element, (slotName, childElement) -> {
        if (slotName != null)
          return false;

        Set<String> consumedChildAttributes = new HashSet<>();

        Boolean expand = context.readBooleanAttribute(childElement,
            TemplateParseContext.CUSTOM_LAYOUT_ATTR_PREFIX + "expand", null,
            consumedChildAttributes);
        Alignment alignSelf = context.readEnumAttribute(childElement,
            TemplateParseContext.CUSTOM_LAYOUT_ATTR_PREFIX + "align-self", ALIGNMENT::get, null,
            consumedChildAttributes);
        Double flexGrow = context.readDoubleAttribute(childElement,
            TemplateParseContext.CUSTOM_LAYOUT_ATTR_PREFIX + "flex-grow", null,
            consumedChildAttributes);

        Component childComponent = context.readComponent(childElement, consumedChildAttributes);
        flexComponent.add(childComponent);

        if (expand != null && expand)
          flexComponent.expand(childComponent);
        if (alignSelf != null)
          flexComponent.setAlignSelf(alignSelf, childComponent);
        if (flexGrow != null)
          flexComponent.setFlexGrow(flexGrow, childComponent);

        if (flexComponent instanceof FlexLayout)
        {
          FlexLayout flexLayout = (FlexLayout) flexComponent;

          String flexBasis = context.readStringAttribute(childElement,
              TemplateParseContext.CUSTOM_LAYOUT_ATTR_PREFIX + "flex-basis", null,
              consumedChildAttributes);
          Double flexShrink = context.readDoubleAttribute(childElement,
              TemplateParseContext.CUSTOM_LAYOUT_ATTR_PREFIX + "flex-shrink", null,
              consumedChildAttributes);

          if (flexBasis != null)
            flexLayout.setFlexBasis(flexBasis, childComponent);
          if (flexShrink != null)
            flexLayout.setFlexShrink(flexShrink, childComponent);
        }

        return true;
      }, textNode -> {
        flexComponent.add(textNode.text());
      });
    }

    return component;
  }

  @Override
  public void postProcessComponent(Element element, Component component,
      TemplateParseContext context, Set<String> consumedAttributes)
  {
    if (component instanceof ThemableLayout)
    {
      ThemableLayout themableLayout = (ThemableLayout) component;

      context.readBooleanAttribute(element, TemplateParseContext.CUSTOM_ATTR_PREFIX + "margin",
          themableLayout::setMargin, consumedAttributes);
      context.readBooleanAttribute(element, TemplateParseContext.CUSTOM_ATTR_PREFIX + "padding",
          themableLayout::setPadding, consumedAttributes);
      context.readBooleanAttribute(element, TemplateParseContext.CUSTOM_ATTR_PREFIX + "spacing",
          themableLayout::setSpacing, consumedAttributes);
      context.readEnumAttribute(element, TemplateParseContext.CUSTOM_ATTR_PREFIX + "box-sizing",
          BOX_SIZING::get, themableLayout::setBoxSizing, consumedAttributes);
    }

    if (component instanceof FlexComponent)
    {
      FlexComponent<?> flexComponent = (FlexComponent<?>) component;

      context.readEnumAttribute(element, TemplateParseContext.CUSTOM_ATTR_PREFIX + "align-items",
          ALIGNMENT::get, flexComponent::setAlignItems, consumedAttributes);
      context.readEnumAttribute(element,
          TemplateParseContext.CUSTOM_ATTR_PREFIX + "justify-content", JUSTIFY_CONTENT::get,
          flexComponent::setJustifyContentMode, consumedAttributes);
    }
  }

}
