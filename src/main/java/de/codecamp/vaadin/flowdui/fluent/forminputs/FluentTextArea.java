package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextAreaVariant;

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


public class FluentTextArea
  extends FluentAbstractField<TextArea, FluentTextArea, String>
  implements
    FluentHasSize<TextArea, FluentTextArea>,
    FluentHasValidation<TextArea, FluentTextArea>,
    FluentHasValueChangeMode<TextArea, FluentTextArea>,
    FluentHasPrefixAndSuffix<TextArea, FluentTextArea>,
    FluentInputNotifier<TextArea, FluentTextArea>,
    FluentKeyNotifier<TextArea, FluentTextArea>,
    FluentCompositionNotifier<TextArea, FluentTextArea>,
    FluentHasAutocomplete<TextArea, FluentTextArea>,
    FluentHasAutocapitalize<TextArea, FluentTextArea>,
    FluentHasAutocorrect<TextArea, FluentTextArea>,
    FluentHasHelper<TextArea, FluentTextArea>,
    FluentHasStyle<TextArea, FluentTextArea>,
    FluentFocusable<TextArea, FluentTextArea>,
    FluentHasTheme<TextArea, FluentTextArea>,
    FluentHasThemeVariants<TextArea, FluentTextArea, TextAreaVariant>
{

  public FluentTextArea()
  {
    this(new TextArea());
  }

  public FluentTextArea(TextArea component)
  {
    super(component);
  }


  public FluentTextArea label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentTextArea placeholder(String placeholder)
  {
    getComponent().setPlaceholder(placeholder);
    return this;
  }

  public FluentTextArea autoselect(boolean autoselect)
  {
    getComponent().setAutoselect(autoselect);
    return this;
  }

  public FluentTextArea autofocus(boolean autofocus)
  {
    getComponent().setAutofocus(autofocus);
    return this;
  }

  public FluentTextArea clearButtonVisible(boolean clearButtonVisible)
  {
    getComponent().setClearButtonVisible(clearButtonVisible);
    return this;
  }

  public FluentTextArea maxLength(int maxLength)
  {
    getComponent().setMaxLength(maxLength);
    return this;
  }

  public FluentTextArea minLength(int minLength)
  {
    getComponent().setMinLength(minLength);
    return this;
  }

  public FluentTextArea preventInvalidInput(boolean preventInvalidInput)
  {
    getComponent().setPreventInvalidInput(preventInvalidInput);
    return this;
  }

  public FluentTextArea required(boolean required)
  {
    getComponent().setRequired(required);
    return this;
  }

  @Override
  public FluentTextArea addThemeVariants(TextAreaVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentTextArea removeThemeVariants(TextAreaVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentTextArea small()
  {
    return addThemeVariants(TextAreaVariant.LUMO_SMALL);
  }

  public FluentTextArea medium()
  {
    return removeThemeVariants(TextAreaVariant.LUMO_SMALL);
  }

  public FluentTextArea alignLeft()
  {
    return removeThemeVariants(TextAreaVariant.LUMO_ALIGN_CENTER, TextAreaVariant.LUMO_ALIGN_RIGHT);
  }

  public FluentTextArea alignCenter()
  {
    removeThemeVariants(TextAreaVariant.LUMO_ALIGN_RIGHT);
    return addThemeVariants(TextAreaVariant.LUMO_ALIGN_CENTER);
  }

  public FluentTextArea alignRight()
  {
    removeThemeVariants(TextAreaVariant.LUMO_ALIGN_CENTER);
    return addThemeVariants(TextAreaVariant.LUMO_ALIGN_RIGHT);
  }

  @Override
  public FluentTextArea helperAboveField(boolean enabled)
  {
    return themeVariant(TextAreaVariant.LUMO_HELPER_ABOVE_FIELD, enabled);
  }

}
