package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.PasswordField;

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


public class FluentPasswordField
  extends FluentAbstractField<PasswordField, FluentPasswordField, String>
  implements
    FluentHasSize<PasswordField, FluentPasswordField>,
    FluentHasValidation<PasswordField, FluentPasswordField>,
    FluentHasValueChangeMode<PasswordField, FluentPasswordField>,
    FluentHasPrefixAndSuffix<PasswordField, FluentPasswordField>,
    FluentInputNotifier<PasswordField, FluentPasswordField>,
    FluentKeyNotifier<PasswordField, FluentPasswordField>,
    FluentCompositionNotifier<PasswordField, FluentPasswordField>,
    FluentHasAutocomplete<PasswordField, FluentPasswordField>,
    FluentHasAutocapitalize<PasswordField, FluentPasswordField>,
    FluentHasAutocorrect<PasswordField, FluentPasswordField>,
    FluentHasHelper<PasswordField, FluentPasswordField>,
    FluentHasStyle<PasswordField, FluentPasswordField>,
    FluentFocusable<PasswordField, FluentPasswordField>,
    FluentHasTheme<PasswordField, FluentPasswordField>
{

  public FluentPasswordField()
  {
    this(new PasswordField());
  }

  public FluentPasswordField(PasswordField component)
  {
    super(component);
  }


  public FluentPasswordField label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentPasswordField placeholder(String placeholder)
  {
    getComponent().setPlaceholder(placeholder);
    return this;
  }

  public FluentPasswordField autoselect(boolean autoselect)
  {
    getComponent().setAutoselect(autoselect);
    return this;
  }

  public FluentPasswordField autofocus(boolean autofocus)
  {
    getComponent().setAutofocus(autofocus);
    return this;
  }

  public FluentPasswordField clearButtonVisible(boolean clearButtonVisible)
  {
    getComponent().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentPasswordField maxLength(int maxLength)
  {
    getComponent().setMaxLength(maxLength);
    return this;
  }

  public FluentPasswordField minLength(int minLength)
  {
    getComponent().setMinLength(minLength);
    return this;
  }

  public FluentPasswordField pattern(String pattern)
  {
    getComponent().setPattern(pattern);
    return this;
  }

  public FluentPasswordField preventInvalidInput(boolean preventInvalidInput)
  {
    getComponent().setPreventInvalidInput(preventInvalidInput);
    return this;
  }

  public FluentPasswordField required(boolean required)
  {
    getComponent().setRequired(required);
    return this;
  }

}
