package de.codecamp.vaadin.flowdui.fluent.forminputs;

import java.math.BigDecimal;
import java.util.Locale;

import com.vaadin.flow.component.textfield.BigDecimalField;

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


public class FluentBigDecimalField
  extends FluentAbstractField<BigDecimalField, FluentBigDecimalField, BigDecimal>
  implements
    FluentHasSize<BigDecimalField, FluentBigDecimalField>,
    FluentHasValidation<BigDecimalField, FluentBigDecimalField>,
    FluentHasValueChangeMode<BigDecimalField, FluentBigDecimalField>,
    FluentHasPrefixAndSuffix<BigDecimalField, FluentBigDecimalField>,
    FluentInputNotifier<BigDecimalField, FluentBigDecimalField>,
    FluentKeyNotifier<BigDecimalField, FluentBigDecimalField>,
    FluentCompositionNotifier<BigDecimalField, FluentBigDecimalField>,
    FluentHasAutocomplete<BigDecimalField, FluentBigDecimalField>,
    FluentHasAutocapitalize<BigDecimalField, FluentBigDecimalField>,
    FluentHasAutocorrect<BigDecimalField, FluentBigDecimalField>,
    FluentHasHelper<BigDecimalField, FluentBigDecimalField>,
    FluentHasStyle<BigDecimalField, FluentBigDecimalField>,
    FluentFocusable<BigDecimalField, FluentBigDecimalField>,
    FluentHasTheme<BigDecimalField, FluentBigDecimalField>
{

  public FluentBigDecimalField()
  {
    this(new BigDecimalField());
  }

  public FluentBigDecimalField(BigDecimalField component)
  {
    super(component);
  }


  public FluentBigDecimalField label(String label)
  {
    get().setLabel(label);
    return this;
  }

  public FluentBigDecimalField placeholder(String placeholder)
  {
    get().setPlaceholder(placeholder);
    return this;
  }

  public FluentBigDecimalField autoselect(boolean autoselect)
  {
    get().setAutoselect(autoselect);
    return this;
  }

  public FluentBigDecimalField autofocus(boolean autofocus)
  {
    get().setAutofocus(autofocus);
    return this;
  }

  public FluentBigDecimalField clearButtonVisible(boolean clearButtonVisible)
  {
    get().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentBigDecimalField setLocale(Locale locale)
  {
    get().setLocale(locale);
    return this;
  }

}
