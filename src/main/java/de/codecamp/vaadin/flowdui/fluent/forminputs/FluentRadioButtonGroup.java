package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializablePredicate;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;
import de.codecamp.vaadin.flowdui.fluent.FluentSingleSelect;


public class FluentRadioButtonGroup<ITEM>
  extends FluentAbstractField<RadioButtonGroup<ITEM>, FluentRadioButtonGroup<ITEM>, ITEM>
  implements
    FluentSingleSelect<RadioButtonGroup<ITEM>, FluentRadioButtonGroup<ITEM>, ITEM>,
    FluentHasValidation<RadioButtonGroup<ITEM>, FluentRadioButtonGroup<ITEM>>,
    FluentHasHelper<RadioButtonGroup<ITEM>, FluentRadioButtonGroup<ITEM>>,
    FluentHasStyle<RadioButtonGroup<ITEM>, FluentRadioButtonGroup<ITEM>>,
    FluentHasTheme<RadioButtonGroup<ITEM>, FluentRadioButtonGroup<ITEM>>,
    FluentHasThemeVariants<RadioButtonGroup<ITEM>, FluentRadioButtonGroup<ITEM>, RadioGroupVariant>
{

  public FluentRadioButtonGroup()
  {
    super(new RadioButtonGroup<>());
  }

  public FluentRadioButtonGroup(RadioButtonGroup<ITEM> component)
  {
    super(component);
  }


  public FluentRadioButtonGroup<ITEM> label(String label)
  {
    get().setLabel(label);
    return this;
  }

  public FluentRadioButtonGroup<ITEM> required(boolean required)
  {
    get().setRequired(required);
    return this;
  }

  public FluentRadioButtonGroup<ITEM> renderer(
      ComponentRenderer<? extends Component, ITEM> itemRenderer)
  {
    get().setRenderer(itemRenderer);
    return this;
  }

  public FluentRadioButtonGroup<ITEM> itemEnabledProvider(
      SerializablePredicate<ITEM> itemEnabledProvider)
  {
    get().setItemEnabledProvider(itemEnabledProvider);
    return this;
  }

  @Override
  public FluentRadioButtonGroup<ITEM> addThemeVariants(RadioGroupVariant... variants)
  {
    get().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentRadioButtonGroup<ITEM> removeThemeVariants(RadioGroupVariant... variants)
  {
    get().removeThemeVariants(variants);
    return this;
  }

  public FluentRadioButtonGroup<ITEM> vertical(boolean enabled)
  {
    return themeVariant(RadioGroupVariant.LUMO_VERTICAL, enabled);
  }

  @Override
  public FluentRadioButtonGroup<ITEM> helperAboveField(boolean enabled)
  {
    return themeVariant(RadioGroupVariant.LUMO_HELPER_ABOVE_FIELD, enabled);
  }

}
