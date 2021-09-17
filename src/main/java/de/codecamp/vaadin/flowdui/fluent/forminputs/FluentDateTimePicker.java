package de.codecamp.vaadin.flowdui.fluent.forminputs;

import java.time.Duration;
import java.time.LocalDateTime;

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
    getComponent().setLabel(label);
    return this;
  }

  public FluentDateTimePicker datePlaceholder(String placeholder)
  {
    getComponent().setDatePlaceholder(placeholder);
    return this;
  }

  public FluentDateTimePicker timePlaceholder(String placeholder)
  {
    getComponent().setTimePlaceholder(placeholder);
    return this;
  }

  public FluentDateTimePicker autoOpen(boolean autoOpen)
  {
    getComponent().setAutoOpen(autoOpen);
    return this;
  }

  public FluentDateTimePicker weekNumbersVisible(boolean weekNumbersVisible)
  {
    getComponent().setWeekNumbersVisible(weekNumbersVisible);
    return this;
  }

  public FluentDateTimePicker max(LocalDateTime max)
  {
    getComponent().setMax(max);
    return this;
  }

  public FluentDateTimePicker min(LocalDateTime min)
  {
    getComponent().setMin(min);
    return this;
  }

  public FluentDateTimePicker step(Duration step)
  {
    getComponent().setStep(step);
    return this;
  }

}