package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.GeneratedVaadinComboBox.CustomValueSetEvent;
import com.vaadin.flow.data.renderer.Renderer;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;


public class FluentComboBox<ITEM>
  extends FluentAbstractField<ComboBox<ITEM>, FluentComboBox<ITEM>, ITEM>
  implements
    FluentHasSize<ComboBox<ITEM>, FluentComboBox<ITEM>>,
    FluentHasValidation<ComboBox<ITEM>, FluentComboBox<ITEM>>,
    FluentHasHelper<ComboBox<ITEM>, FluentComboBox<ITEM>>,
    FluentHasStyle<ComboBox<ITEM>, FluentComboBox<ITEM>>,
    FluentFocusable<ComboBox<ITEM>, FluentComboBox<ITEM>>
{

  public FluentComboBox()
  {
    super(new ComboBox<>());
  }

  public FluentComboBox(ComboBox<ITEM> component)
  {
    super(component);
  }


  public FluentComboBox<ITEM> label(String label)
  {
    get().setLabel(label);
    return this;
  }

  public FluentComboBox<ITEM> placeholder(String placeholder)
  {
    get().setPlaceholder(placeholder);
    return this;
  }

  public FluentComboBox<ITEM> pattern(String pattern)
  {
    get().setPattern(pattern);
    return this;

  }

  public FluentComboBox<ITEM> itemLabelGenerator(ItemLabelGenerator<ITEM> itemLabelGenerator)
  {
    get().setItemLabelGenerator(itemLabelGenerator);
    return this;
  }

  public FluentComboBox<ITEM> renderer(Renderer<ITEM> renderer)
  {
    get().setRenderer(renderer);
    return this;
  }

  public FluentComboBox<ITEM> pageSize(int pageSize)
  {
    get().setPageSize(pageSize);
    return this;
  }

  public FluentComboBox<ITEM> opened(boolean opened)
  {
    get().setOpened(opened);
    return this;
  }

  public FluentComboBox<ITEM> autoOpen(boolean autoOpen)
  {
    get().setAutoOpen(autoOpen);
    return this;
  }

  public FluentComboBox<ITEM> autofocus(boolean autofocus)
  {
    get().setAutofocus(autofocus);
    return this;
  }

  public FluentComboBox<ITEM> preventInvalidInput(boolean preventInvalidInput)
  {
    get().setPreventInvalidInput(preventInvalidInput);
    return this;
  }


  public FluentComboBox<ITEM> required(boolean required)
  {
    get().setRequired(required);
    return this;
  }

  public FluentComboBox<ITEM> allowCustomValue(boolean allowCustomValue)
  {
    get().setAllowCustomValue(allowCustomValue);
    return this;
  }

  public FluentComboBox<ITEM> onCustomValueSet(
      ComponentEventListener<CustomValueSetEvent<ComboBox<ITEM>>> listener)
  {
    get().addCustomValueSetListener(listener);
    return this;
  }

  public FluentComboBox<ITEM> clearButtonVisible(boolean clearButtonVisible)
  {
    get().setClearButtonVisible(clearButtonVisible);
    return this;
  }

}


