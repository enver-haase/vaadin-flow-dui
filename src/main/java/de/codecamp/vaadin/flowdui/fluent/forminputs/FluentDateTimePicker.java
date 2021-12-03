package de.codecamp.vaadin.flowdui.fluent.forminputs;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;

import com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;


public class FluentDateTimePicker
  extends FluentAbstractField<DateTimePicker, FluentDateTimePicker, LocalDateTime>
  implements
    FluentHasStyle<DateTimePicker, FluentDateTimePicker>,
    FluentHasSize<DateTimePicker, FluentDateTimePicker>,
    FluentHasTheme<DateTimePicker, FluentDateTimePicker>,
    FluentHasValidation<DateTimePicker, FluentDateTimePicker>,
    FluentFocusable<DateTimePicker, FluentDateTimePicker>,
    FluentHasHelper<DateTimePicker, FluentDateTimePicker>
{

  public FluentDateTimePicker()
  {
    this(new DateTimePicker());
  }

  public FluentDateTimePicker(DateTimePicker component)
  {
    super(component);
  }


  public FluentDateTimePicker label(String label)
  {
    get().setLabel(label);
    return this;
  }

  public FluentDateTimePicker datePlaceholder(String placeholder)
  {
    get().setDatePlaceholder(placeholder);
    return this;
  }

  public FluentDateTimePicker timePlaceholder(String placeholder)
  {
    get().setTimePlaceholder(placeholder);
    return this;
  }

  public FluentDateTimePicker autoOpen(boolean autoOpen)
  {
    get().setAutoOpen(autoOpen);
    return this;
  }

  public FluentDateTimePicker weekNumbersVisible(boolean weekNumbersVisible)
  {
    get().setWeekNumbersVisible(weekNumbersVisible);
    return this;
  }

  public FluentDateTimePicker min(LocalDateTime min)
  {
    get().setMin(min);
    return this;
  }

  public FluentDateTimePicker max(LocalDateTime max)
  {
    get().setMax(max);
    return this;
  }

  public FluentDateTimePicker locale(Locale locale)
  {
    get().setLocale(locale);
    return this;
  }

  public FluentDateTimePicker step(Duration step)
  {
    get().setStep(step);
    return this;
  }

  public FluentDateTimePicker datePickerI18n(DatePickerI18n i18n)
  {
    get().setDatePickerI18n(i18n);
    return this;
  }

}
