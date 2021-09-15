package de.codecamp.vaadin.flowdui.fluent.forminputs;

import java.time.Duration;
import java.time.LocalTime;

import com.vaadin.flow.component.timepicker.TimePicker;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasEnabled;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;


public class FluentTimePicker
  extends FluentAbstractField<TimePicker, FluentTimePicker, LocalTime>
  implements
    FluentHasSize<TimePicker, FluentTimePicker>,
    FluentHasValidation<TimePicker, FluentTimePicker>,
    FluentHasEnabled<TimePicker, FluentTimePicker>,
    FluentHasHelper<TimePicker, FluentTimePicker>,
    FluentHasStyle<TimePicker, FluentTimePicker>,
    FluentFocusable<TimePicker, FluentTimePicker>
{

  public FluentTimePicker()
  {
    this(new TimePicker());
  }

  public FluentTimePicker(TimePicker component)
  {
    super(component);
  }


  public FluentTimePicker label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentTimePicker placeholder(String placeholder)
  {
    getComponent().setPlaceholder(placeholder);
    return this;
  }

  public FluentTimePicker autoOpen(boolean autoOpen)
  {
    getComponent().setAutoOpen(autoOpen);
    return this;
  }

  public FluentTimePicker clearButtonVisible(boolean clearButtonVisible)
  {
    getComponent().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentTimePicker maxTime(LocalTime max)
  {
    getComponent().setMaxTime(max);
    return this;
  }

  public FluentTimePicker minTime(LocalTime min)
  {
    getComponent().setMinTime(min);
    return this;
  }

  public FluentTimePicker step(Duration step)
  {
    getComponent().setStep(step);
    return this;
  }

  public FluentTimePicker required(boolean required)
  {
    getComponent().setRequired(required);
    return this;
  }

}
