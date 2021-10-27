package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.NumberField;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentCompositionNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValueChangeMode;
import de.codecamp.vaadin.flowdui.fluent.FluentInputNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentKeyNotifier;


public class FluentNumberField
  extends FluentAbstractField<NumberField, FluentNumberField, Double>
  implements
    FluentHasSize<NumberField, FluentNumberField>,
    FluentHasValidation<NumberField, FluentNumberField>,
    FluentHasValueChangeMode<NumberField, FluentNumberField>,
    FluentHasPrefixAndSuffix<NumberField, FluentNumberField>,
    FluentInputNotifier<NumberField, FluentNumberField>,
    FluentKeyNotifier<NumberField, FluentNumberField>,
    FluentCompositionNotifier<NumberField, FluentNumberField>,
    FluentHasAutocomplete<NumberField, FluentNumberField>,
    FluentHasAutocapitalize<NumberField, FluentNumberField>,
    FluentHasAutocorrect<NumberField, FluentNumberField>,
    FluentHasHelper<NumberField, FluentNumberField>,
    FluentHasStyle<NumberField, FluentNumberField>,
    FluentFocusable<NumberField, FluentNumberField>,
    FluentHasTheme<NumberField, FluentNumberField>
{

  public FluentNumberField()
  {
    this(new NumberField());
  }

  public FluentNumberField(NumberField component)
  {
    super(component);
  }


  public FluentNumberField label(String label)
  {
    get().setLabel(label);
    return this;
  }

  public FluentNumberField placeholder(String placeholder)
  {
    get().setPlaceholder(placeholder);
    return this;
  }

  public FluentNumberField autoselect(boolean autoselect)
  {
    get().setAutoselect(autoselect);
    return this;
  }

  public FluentNumberField autofocus(boolean autofocus)
  {
    get().setAutofocus(autofocus);
    return this;
  }

  public FluentNumberField clearButtonVisible(boolean clearButtonVisible)
  {
    get().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentNumberField setHasControls(boolean hasControls)
  {
    get().setHasControls(hasControls);
    return this;
  }

  public FluentNumberField setMin(double min)
  {
    get().setMin(min);
    return this;
  }

  public FluentNumberField setMax(double max)
  {
    get().setMax(max);
    return this;
  }

  public FluentNumberField setStep(double step)
  {
    get().setStep(step);
    return this;
  }

}
