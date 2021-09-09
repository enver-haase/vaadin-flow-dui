package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class ButtonFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-button":
        Button button = new Button();
        context.readBooleanAttribute(element, "autofocus", button::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element,
            TemplateParserContext.CUSTOM_ATTR_PREFIX + "disable-on-click",
            button::setDisableOnClick, consumedAttributes);

        AtomicBoolean iconFound = new AtomicBoolean(false);
        context.readChildren(button, element, (slotName, childElement) -> {
          if (slotName == null)
          {
            button.getElement().appendChild(context.readComponent(childElement, null).getElement());
            return true;
          }
          switch (slotName)
          {
            case "prefix":
            case "suffix":
              if (iconFound.get())
              {
                throw new TemplateException(context.getTemplateId(), element,
                    "Slot 'prefix' or 'suffix' already filled. Button only supports one of them.");
              }
              button.setIcon(context.readComponentForSlot(childElement, null));
              if (slotName.equals("suffix"))
                button.setIconAfterText(true);
              iconFound.set(true);
              return true;
            default:
              return false;
          }
        }, textNode -> {
          button.getElement().appendChild(com.vaadin.flow.dom.Element.createText(textNode.text()));
        });
        return button;
    }
    return null;
  }

}
