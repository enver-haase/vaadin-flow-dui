package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;


public class CustomFieldFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-custom-field":
        CustomField customField = new CustomField();
        context.readStringAttribute(element, "label",
            v -> customField.getElement().setAttribute("label", v), consumedAttributes);
        context.readChildren(element, (slotName, childElement) -> {
          if (slotName != null)
            return false;
          customField.add(context.readComponent(childElement, null));
          return true;
        }, textNode -> {
          customField.add(new Text(textNode.text()));
        });
        return customField;
    }

    return null;
  }


  @Tag("vaadin-custom-field")
  public static class CustomField
    extends Div
  {

  }

}
