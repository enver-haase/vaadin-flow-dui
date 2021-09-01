package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.time.Duration;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class DateTimePickerFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-date-time-picker":
        DateTimePicker datePicker = new DateTimePicker();
        context.readStringAttribute(element, "label", datePicker::setLabel, consumedAttributes);
        context.readStringAttribute(element, "date-placeholder", datePicker::setDatePlaceholder,
            consumedAttributes);
        context.readStringAttribute(element, "time-placeholder", datePicker::setTimePlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "show-week-numbers",
            datePicker::setWeekNumbersVisible, consumedAttributes);
        context.readLocalDateTimeAttribute(element, "min", datePicker::setMin, consumedAttributes);
        context.readLocalDateTimeAttribute(element, "max", datePicker::setMax, consumedAttributes);
        context.readDoubleAttribute(element, "step",
            v -> datePicker.setStep(Duration.ofMillis((long) (v * 1000))), consumedAttributes);
        context.readChildren(datePicker, element, null, null);
        return datePicker;
    }

    return null;
  }

}
