package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.function.SerializablePredicate;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;
import de.codecamp.vaadin.flowdui.fluent.FluentMultiSelect;


public class FluentCheckboxGroup<ITEM>
  extends FluentComponent<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>>
  implements
    FluentHasSize<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>>,
    FluentHasValidation<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>>,
    FluentMultiSelect<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>, ITEM>,
    FluentHasHelper<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>>,
    FluentHasStyle<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>>,
    FluentHasTheme<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>>,
    FluentHasThemeVariants<CheckboxGroup<ITEM>, FluentCheckboxGroup<ITEM>, CheckboxGroupVariant>
{

  public FluentCheckboxGroup()
  {
    super(new CheckboxGroup<ITEM>());
  }

  public FluentCheckboxGroup(CheckboxGroup<ITEM> component)
  {
    super(component);
  }


  public FluentCheckboxGroup<ITEM> label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentCheckboxGroup<ITEM> itemLabelGenerator(ItemLabelGenerator<ITEM> itemLabelGenerator)
  {
    getComponent().setItemLabelGenerator(itemLabelGenerator);
    return this;
  }

  public FluentCheckboxGroup<ITEM> itemEnabledProvider(
      SerializablePredicate<ITEM> itemEnabledProvider)
  {
    getComponent().setItemEnabledProvider(itemEnabledProvider);
    return this;
  }

  @Override
  public FluentCheckboxGroup<ITEM> addThemeVariants(CheckboxGroupVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentCheckboxGroup<ITEM> removeThemeVariants(CheckboxGroupVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentCheckboxGroup<ITEM> vertical(boolean enabled)
  {
    return themeVariant(CheckboxGroupVariant.LUMO_VERTICAL, enabled);
  }

  @Override
  public FluentCheckboxGroup<ITEM> helperAboveField(boolean enabled)
  {
    return themeVariant(CheckboxGroupVariant.LUMO_HELPER_ABOVE_FIELD, enabled);
  }

}

