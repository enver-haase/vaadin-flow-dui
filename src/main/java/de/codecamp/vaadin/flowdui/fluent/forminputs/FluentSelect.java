package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializablePredicate;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasHelper;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValidation;
import de.codecamp.vaadin.flowdui.fluent.FluentSingleSelect;


public class FluentSelect<ITEM>
  extends FluentAbstractField<Select<ITEM>, FluentSelect<ITEM>, ITEM>
  implements
    FluentHasStyle<Select<ITEM>, FluentSelect<ITEM>>,
    FluentFocusable<Select<ITEM>, FluentSelect<ITEM>>,
    FluentHasSize<Select<ITEM>, FluentSelect<ITEM>>,
    FluentHasValidation<Select<ITEM>, FluentSelect<ITEM>>,
    FluentSingleSelect<Select<ITEM>, FluentSelect<ITEM>, ITEM>,
    FluentHasHelper<Select<ITEM>, FluentSelect<ITEM>>
{


  public FluentSelect()
  {
    super(new Select<>());
  }

  public FluentSelect(Select<ITEM> component)
  {
    super(component);
  }


  public FluentSelect<ITEM> label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentSelect<ITEM> placeholder(String placeholder)
  {
    getComponent().setPlaceholder(placeholder);
    return this;
  }

  public FluentSelect<ITEM> autofocus(boolean autofocus)
  {
    getComponent().setAutofocus(autofocus);
    return this;
  }

  public FluentSelect<ITEM> itemLabelGenerator(ItemLabelGenerator<ITEM> itemLabelGenerator)
  {
    getComponent().setItemLabelGenerator(itemLabelGenerator);
    return this;
  }

  public FluentSelect<ITEM> itemEnabledProvider(SerializablePredicate<ITEM> itemEnabledProvider)
  {
    getComponent().setItemEnabledProvider(itemEnabledProvider);
    return this;
  }

  public FluentSelect<ITEM> renderer(ComponentRenderer<? extends Component, ITEM> renderer)
  {
    getComponent().setRenderer(renderer);
    return this;
  }

  public FluentSelect<ITEM> textRenderer(ItemLabelGenerator<ITEM> itemLabelGenerator)
  {
    getComponent().setTextRenderer(itemLabelGenerator);
    return this;
  }

}
