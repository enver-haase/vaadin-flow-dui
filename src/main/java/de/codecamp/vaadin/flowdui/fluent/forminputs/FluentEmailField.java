package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.EmailField;

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


public class FluentEmailField
  extends FluentAbstractField<EmailField, FluentEmailField, String>
  implements
    FluentHasSize<EmailField, FluentEmailField>,
    FluentHasValidation<EmailField, FluentEmailField>,
    FluentHasValueChangeMode<EmailField, FluentEmailField>,
    FluentHasPrefixAndSuffix<EmailField, FluentEmailField>,
    FluentInputNotifier<EmailField, FluentEmailField>,
    FluentKeyNotifier<EmailField, FluentEmailField>,
    FluentCompositionNotifier<EmailField, FluentEmailField>,
    FluentHasAutocomplete<EmailField, FluentEmailField>,
    FluentHasAutocapitalize<EmailField, FluentEmailField>,
    FluentHasAutocorrect<EmailField, FluentEmailField>,
    FluentHasHelper<EmailField, FluentEmailField>,
    FluentHasStyle<EmailField, FluentEmailField>,
    FluentFocusable<EmailField, FluentEmailField>,
    FluentHasTheme<EmailField, FluentEmailField>
{

  public FluentEmailField()
  {
    this(new EmailField());
  }

  public FluentEmailField(EmailField component)
  {
    super(component);
  }


  public FluentEmailField label(String label)
  {
    get().setLabel(label);
    return this;
  }

  public FluentEmailField placeholder(String placeholder)
  {
    get().setPlaceholder(placeholder);
    return this;
  }

  public FluentEmailField autoselect(boolean autoselect)
  {
    get().setAutoselect(autoselect);
    return this;
  }

  public FluentEmailField autofocus(boolean autofocus)
  {
    get().setAutofocus(autofocus);
    return this;
  }

  public FluentEmailField clearButtonVisible(boolean clearButtonVisible)
  {
    get().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentEmailField maxLength(int maxLength)
  {
    get().setMaxLength(maxLength);
    return this;
  }

  public FluentEmailField minLength(int minLength)
  {
    get().setMinLength(minLength);
    return this;
  }

  public FluentEmailField pattern(String pattern)
  {
    get().setPattern(pattern);
    return this;
  }

  public FluentEmailField preventInvalidInput(boolean preventInvalidInput)
  {
    get().setPreventInvalidInput(preventInvalidInput);
    return this;
  }

}
