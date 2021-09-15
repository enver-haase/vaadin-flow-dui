package de.codecamp.vaadin.flowdui.fluent.forminputs;

import java.util.Set;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializablePredicate;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentMultiSelect;


public class FluentMultiSelectListBox<ITEM>
  extends FluentAbstractField<MultiSelectListBox<ITEM>, FluentMultiSelectListBox<ITEM>, Set<ITEM>>
  implements
    FluentMultiSelect<MultiSelectListBox<ITEM>, FluentMultiSelectListBox<ITEM>, ITEM>,
    FluentHasSize<MultiSelectListBox<ITEM>, FluentMultiSelectListBox<ITEM>>
{

  public FluentMultiSelectListBox()
  {
    super(new MultiSelectListBox<>());
  }

  public FluentMultiSelectListBox(MultiSelectListBox<ITEM> component)
  {
    super(component);
  }


  public FluentMultiSelectListBox<ITEM> renderer(
      ComponentRenderer<? extends Component, ITEM> itemRenderer)
  {
    getComponent().setRenderer(itemRenderer);
    return this;
  }

  public FluentMultiSelectListBox<ITEM> itemEnabledProvider(
      SerializablePredicate<ITEM> itemEnabledProvider)
  {
    getComponent().setItemEnabledProvider(itemEnabledProvider);
    return this;
  }

}
