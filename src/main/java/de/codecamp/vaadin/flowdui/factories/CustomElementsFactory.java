package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;
import de.codecamp.vaadin.flowdui.components.CustomStyle;
import de.codecamp.vaadin.flowdui.components.Slot;
import de.codecamp.vaadin.flowdui.components.Style;


public class CustomElementsFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "slot":
        Slot slot = new Slot();

        context.readStringAttribute(element, "name", slot::setName, consumedAttributes);

        context.readChildren(slot, element, (slotName, childElement) -> {
          slot.add(context.readComponent(childElement, null));
          return true;
        }, textNode -> {
          slot.add(textNode.text());
        });

        return slot;

      case "style":
        Style style = new Style();
        style.getElement().setProperty("innerHTML", element.data());
        return style;

      case "custom-style":
        CustomStyle customStyle = new CustomStyle();
        customStyle.getElement().setProperty("innerHTML", element.html());
        return customStyle;

    }

    return null;
  }

}
