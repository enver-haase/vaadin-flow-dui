package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateContext;


public class DatePickerFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-date-picker":
        DatePicker datePicker = new DatePicker();
        context.readStringAttribute(element, "label", datePicker::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", datePicker::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "show-week-numbers",
            datePicker::setWeekNumbersVisible, consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            datePicker::setClearButtonVisible, consumedAttributes);
        context.readLocalDateAttribute(element, "initial-position", datePicker::setInitialPosition,
            consumedAttributes);
        context.readChildren(element, null, null);
        return datePicker;
    }

    return null;
  }

}
