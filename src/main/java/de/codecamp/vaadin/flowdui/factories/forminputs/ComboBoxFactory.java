package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class ComboBoxFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-combo-box":
        ComboBox<?> comboBox = new ComboBox<>();
        context.readStringAttribute(element, "label", comboBox::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", comboBox::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            comboBox::setClearButtonVisible, consumedAttributes);
        context.readBooleanAttribute(element, "allow-custom-value", comboBox::setAllowCustomValue,
            consumedAttributes);
        context.readChildren(element, (slotName, childComponent) -> {
          throw new TemplateException(
              "ComboBox cannot be populated using a DUI template. Use its Java API instead.");
        }, null);
        return comboBox;
    }

    return null;
  }

}
