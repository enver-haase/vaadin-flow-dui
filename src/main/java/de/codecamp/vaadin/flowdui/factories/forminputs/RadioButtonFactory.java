package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class RadioButtonFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-radio-group":
        RadioButtonGroup<?> radioButtonGroup = new RadioButtonGroup<>();
        context.readStringAttribute(element, "label", radioButtonGroup::setLabel,
            consumedAttributes);
        context.readChildren(element, (slotName, childComponent) -> {
          throw new TemplateException(
              "RadioButtonGroup cannot be populated using a DUI template. Use its Java API instead.");
        }, null);
        return radioButtonGroup;
    }

    return null;
  }

}
