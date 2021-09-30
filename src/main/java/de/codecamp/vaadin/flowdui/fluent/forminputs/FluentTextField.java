package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentCompositionNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValueChangeMode;
import de.codecamp.vaadin.flowdui.fluent.FluentInputNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentKeyNotifier;


public class FluentTextField
  extends FluentAbstractField<TextField, FluentTextField, String>
  implements
    FluentHasSize<TextField, FluentTextField>,
    FluentHasValidation<TextField, FluentTextField>,
    FluentHasValueChangeMode<TextField, FluentTextField>,
    FluentHasPrefixAndSuffix<TextField, FluentTextField>,
    FluentInputNotifier<TextField, FluentTextField>,
    FluentKeyNotifier<TextField, FluentTextField>,
    FluentCompositionNotifier<TextField, FluentTextField>,
    FluentHasAutocomplete<TextField, FluentTextField>,
    FluentHasAutocapitalize<TextField, FluentTextField>,
    FluentHasAutocorrect<TextField, FluentTextField>,
    FluentHasHelper<TextField, FluentTextField>,
    FluentHasStyle<TextField, FluentTextField>,
    FluentFocusable<TextField, FluentTextField>,
    FluentHasTheme<TextField, FluentTextField>,
    FluentHasThemeVariants<TextField, FluentTextField, TextFieldVariant>
{

  public FluentTextField()
  {
    this(new TextField());
  }

  public FluentTextField(TextField component)
  {
    super(component);
  }


  public FluentTextField label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentTextField placeholder(String placeholder)
  {
    getComponent().setPlaceholder(placeholder);
    return this;
  }

  public FluentTextField autoselect(boolean autoselect)
  {
    getComponent().setAutoselect(autoselect);
    return this;
  }

  public FluentTextField autofocus(boolean autofocus)
  {
    getComponent().setAutofocus(autofocus);
    return this;
  }

  public FluentTextField clearButtonVisible(boolean clearButtonVisible)
  {
    getComponent().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentTextField maxLength(int maxLength)
  {
    getComponent().setMaxLength(maxLength);
    return this;
  }

  public FluentTextField minLength(int minLength)
  {
    getComponent().setMinLength(minLength);
    return this;
  }

  public FluentTextField pattern(String pattern)
  {
    getComponent().setPattern(pattern);
    return this;
  }

  public FluentTextField preventInvalidInput(boolean preventInvalidInput)
  {
    getComponent().setPreventInvalidInput(preventInvalidInput);
    return this;
  }

  public FluentTextField required(boolean required)
  {
    getComponent().setRequired(required);
    return this;
  }

  @Override
  public FluentTextField addThemeVariants(TextFieldVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentTextField removeThemeVariants(TextFieldVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentTextField small()
  {
    return addThemeVariants(TextFieldVariant.LUMO_SMALL);
  }

  public FluentTextField medium()
  {
    return removeThemeVariants(TextFieldVariant.LUMO_SMALL);
  }

  public FluentTextField alignLeft()
  {
    return removeThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER,
        TextFieldVariant.LUMO_ALIGN_RIGHT);
  }

  public FluentTextField alignCenter()
  {
    removeThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
    return addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
  }

  public FluentTextField alignRight()
  {
    removeThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
    return addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
  }

  @Override
  public FluentTextField helperAboveField(boolean enabled)
  {
    return themeVariant(TextFieldVariant.LUMO_HELPER_ABOVE_FIELD, enabled);
  }

}
