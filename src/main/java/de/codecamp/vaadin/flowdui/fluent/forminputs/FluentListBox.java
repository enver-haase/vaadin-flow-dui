package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializablePredicate;

import de.codecamp.vaadin.flowdui.fluent.FluentAbstractField;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentSingleSelect;


public class FluentListBox<ITEM>
  extends FluentAbstractField<ListBox<ITEM>, FluentListBox<ITEM>, ITEM>
  implements
    FluentSingleSelect<ListBox<ITEM>, FluentListBox<ITEM>, ITEM>,
    FluentHasSize<ListBox<ITEM>, FluentListBox<ITEM>>
{

  public FluentListBox()
  {
    super(new ListBox<>());
  }

  public FluentListBox(ListBox<ITEM> component)
  {
    super(component);
  }


  public FluentListBox<ITEM> renderer(ComponentRenderer<? extends Component, ITEM> itemRenderer)
  {
    get().setRenderer(itemRenderer);
    return this;
  }

  public FluentListBox<ITEM> itemEnabledProvider(SerializablePredicate<ITEM> itemEnabledProvider)
  {
    get().setItemEnabledProvider(itemEnabledProvider);
    return this;
  }

}
