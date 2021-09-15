package de.codecamp.vaadin.flowdui.fluent.forminputs;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasEnabled;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;


public class FluentDatePicker
  extends FluentAbstractField<DatePicker, FluentDatePicker, LocalDate>
  implements
    FluentHasSize<DatePicker, FluentDatePicker>,
    FluentHasValidation<DatePicker, FluentDatePicker>,
    FluentHasEnabled<DatePicker, FluentDatePicker>,
    FluentHasHelper<DatePicker, FluentDatePicker>,
    FluentHasStyle<DatePicker, FluentDatePicker>,
    FluentFocusable<DatePicker, FluentDatePicker>
{

  public FluentDatePicker()
  {
    this(new DatePicker());
  }

  public FluentDatePicker(DatePicker component)
  {
    super(component);
  }


  public FluentDatePicker label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentDatePicker placeholder(String placeholder)
  {
    getComponent().setPlaceholder(placeholder);
    return this;
  }

  public FluentDatePicker autoOpen(boolean autoOpen)
  {
    getComponent().setAutoOpen(autoOpen);
    return this;
  }

  public FluentDatePicker opened(boolean opened)
  {
    getComponent().setOpened(opened);
    return this;
  }

  public FluentDatePicker clearButtonVisible(boolean clearButtonVisible)
  {
    getComponent().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentDatePicker weekNumbersVisible(boolean weekNumbersVisible)
  {
    getComponent().setWeekNumbersVisible(weekNumbersVisible);
    return this;
  }

  public FluentDatePicker initialPosition(LocalDate initialPosition)
  {
    getComponent().setInitialPosition(initialPosition);
    return this;
  }

  public FluentDatePicker max(LocalDate max)
  {
    getComponent().setMax(max);
    return this;
  }

  public FluentDatePicker min(LocalDate min)
  {
    getComponent().setMin(min);
    return this;
  }

  public FluentDatePicker required(boolean required)
  {
    getComponent().setRequired(required);
    return this;
  }

}
