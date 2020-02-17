package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.time.Duration;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.timepicker.TimePicker;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateContext;


public class TimePickerFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-time-picker":
        TimePicker timePicker = new TimePicker();
        context.readStringAttribute(element, "label", timePicker::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", timePicker::setPlaceholder,
            consumedAttributes);
        context.readStringAttribute(element, "min", timePicker::setMin, consumedAttributes);
        context.readStringAttribute(element, "max", timePicker::setMax, consumedAttributes);
        context.readDoubleAttribute(element, "step",
            v -> timePicker.setStep(Duration.ofMillis((long) (v * 1000))), consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            timePicker::setClearButtonVisible, consumedAttributes);
        context.readLocalTimeAttribute(element, "value", timePicker::setValue, consumedAttributes);
        context.readChildren(element, null, null);
        return timePicker;
    }

    return null;
  }

}
