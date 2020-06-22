package de.codecamp.vaadin.flowdui.factories.layouts;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;


public class FormLayoutFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-form-layout":
        FormLayout formLayout = new FormLayout();
        context.readChildren(element, (slotName, childElement) -> {
          if (slotName != null)
            return false;

          Set<String> consumedChildAttributes = new HashSet<>();
          Integer colspan =
              context.readIntegerAttribute(childElement, "colspan", null, consumedChildAttributes);
          Component childComponent = context.readComponent(childElement, consumedChildAttributes);
          formLayout.add(childComponent);
          if (colspan != null)
            formLayout.setColspan(childComponent, colspan);
          return true;
        }, textNode -> {
          formLayout.add(textNode.text());
        });
        return formLayout;

      case "vaadin-form-item":
        ExtFormItem formItem = new ExtFormItem();
        context.readChildren(element, (slotName, childElement) -> {
          if (slotName == null)
          {
            formItem.add(context.readComponent(childElement, null));
            return true;
          }
          switch (slotName)
          {
            case "label":
              formItem.addToLabel(context.readComponentForSlot(childElement, null));
            default:
              return false;
          }
        }, textNode -> {
          formItem.add(textNode.text());
        });
        return formItem;
    }

    return null;
  }


  private static class ExtFormItem
    extends FormItem
  {

    @Override
    public void addToLabel(Component... components)
    {
      super.addToLabel(components);
    }

  }

}
