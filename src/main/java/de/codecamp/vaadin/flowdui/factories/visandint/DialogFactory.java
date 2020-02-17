package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dialog.Dialog;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class DialogFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateContext context,
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
        if (element.children().size() > 1)
          throw new TemplateException(element, "Dialog only supports a single <template> element.");
        context.readChildren(element, (slotName, childElement) -> {
          if (slotName != null)
            return false;
          switch (childElement.tagName())
          {
            case "template":
              context.readChildren(childElement, (slotName2, childElement2) -> {
                if (slotName2 != null)
                  return false;
                dialog.add(context.readComponent(childElement2, null));
                return true;
              }, textNode -> {
                dialog.add(textNode.text());
              });
              return true;
            default:
              return false;
          }
        }, null);
        return dialog;
    }

    return null;
  }

}
