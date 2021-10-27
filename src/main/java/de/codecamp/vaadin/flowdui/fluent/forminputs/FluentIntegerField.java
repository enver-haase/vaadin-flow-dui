package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.IntegerField;

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


public class FluentIntegerField
  extends FluentAbstractField<IntegerField, FluentIntegerField, Integer>
  implements
    FluentHasSize<IntegerField, FluentIntegerField>,
    FluentHasValidation<IntegerField, FluentIntegerField>,
    FluentHasValueChangeMode<IntegerField, FluentIntegerField>,
    FluentHasPrefixAndSuffix<IntegerField, FluentIntegerField>,
    FluentInputNotifier<IntegerField, FluentIntegerField>,
    FluentKeyNotifier<IntegerField, FluentIntegerField>,
    FluentCompositionNotifier<IntegerField, FluentIntegerField>,
    FluentHasAutocomplete<IntegerField, FluentIntegerField>,
    FluentHasAutocapitalize<IntegerField, FluentIntegerField>,
    FluentHasAutocorrect<IntegerField, FluentIntegerField>,
    FluentHasHelper<IntegerField, FluentIntegerField>,
    FluentHasStyle<IntegerField, FluentIntegerField>,
    FluentFocusable<IntegerField, FluentIntegerField>,
    FluentHasTheme<IntegerField, FluentIntegerField>
{

  public FluentIntegerField()
  {
    this(new IntegerField());
  }

  public FluentIntegerField(IntegerField component)
  {
    super(component);
  }


  public FluentIntegerField label(String label)
  {
    get().setLabel(label);
    return this;
  }

  public FluentIntegerField placeholder(String placeholder)
  {
    get().setPlaceholder(placeholder);
    return this;
  }

  public FluentIntegerField autoselect(boolean autoselect)
  {
    get().setAutoselect(autoselect);
    return this;
  }

  public FluentIntegerField autofocus(boolean autofocus)
  {
    get().setAutofocus(autofocus);
    return this;
  }

  public FluentIntegerField clearButtonVisible(boolean clearButtonVisible)
  {
    get().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentIntegerField setHasControls(boolean hasControls)
  {
    get().setHasControls(hasControls);
    return this;
  }

  public FluentIntegerField setMin(int min)
  {
    get().setMin(min);
    return this;
  }

  public FluentIntegerField setMax(int max)
  {
    get().setMax(max);
    return this;
  }

  public FluentIntegerField setStep(int step)
  {
    get().setStep(step);
    return this;
  }

}
