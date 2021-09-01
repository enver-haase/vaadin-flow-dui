package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dialog.Dialog;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class DialogFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-dialog":
        Dialog dialog = new Dialog();
        context.readBooleanAttribute(element, "no-close-on-esc", v -> dialog.setCloseOnEsc(!v),
            consumedAttributes);
        context.readBooleanAttribute(element, "no-close-on-outside-click",
            v -> dialog.setCloseOnOutsideClick(!v), consumedAttributes);

        context.readChildren(dialog, element, (slotName, childElement) -> {
          if (slotName != null)
            return false;
          dialog.add(context.readComponent(childElement, null));
          return true;
        }, textNode -> {
          dialog.add(textNode.text());
        });

        return dialog;
    }

    return null;
  }

}
