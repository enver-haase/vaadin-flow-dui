package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class CheckboxFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-checkbox":
        Checkbox checkbox = new Checkbox();
        context.readBooleanAttribute(element, "checked", checkbox::setValue, consumedAttributes);
        context.readBooleanAttribute(element, "indeterminate", checkbox::setIndeterminate,
            consumedAttributes);
        checkbox.setLabelAsHtml(element.html());
        return checkbox;

      case "vaadin-checkbox-group":
        CheckboxGroup<?> checkboxGroup = new CheckboxGroup<>();
        context.readStringAttribute(element, "label", checkboxGroup::setLabel, consumedAttributes);
        context.readChildren(checkboxGroup, element, (slotName, childComponent) -> {
          throw new TemplateException(
              "CheckboxGroup cannot be populated using a template. Use its Java API instead.");
        }, null);

        return checkboxGroup;
    }

    return null;
  }

}
