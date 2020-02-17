package de.codecamp.vaadin.flowdui.factories;

import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateContext;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.components.CustomStyle;
import de.codecamp.vaadin.flowdui.components.Slot;
import de.codecamp.vaadin.flowdui.components.Style;


public class CustomElementsFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "slot":
        Slot slot = new Slot();

        String slotName =
            context.readStringAttribute(element, "name", slot::setName, consumedAttributes);

        boolean replace =
            context.readBooleanAttribute(element, "replace", null, consumedAttributes);

        List<Component> slotables = context.getSlotablesForSlot(slotName);
        if (replace && slotables.size() > 1)
        {
          throw new TemplateException(element,
              "<slot> can only be replaced by a single Component.");
        }

        if (replace)
        {
          if (slotables.isEmpty())
            return slot;
          else
            return slotables.get(0);
        }

        slotables.forEach(s -> s.getElement().setAttribute("slot", slotName));
        slot.add(slotables.toArray(new Component[slotables.size()]));

        context.readChildren(element, (slotName2, childElement) -> {
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
