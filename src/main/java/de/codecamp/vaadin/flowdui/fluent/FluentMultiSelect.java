package de.codecamp.vaadin.flowdui.fluent;

import java.util.Set;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.selection.MultiSelect;
import com.vaadin.flow.data.selection.MultiSelectionListener;


@SuppressWarnings("unchecked")
public interface FluentMultiSelect<C extends Component & MultiSelect<C, I>, F extends FluentMultiSelect<C, F, I>, I>
  extends
    FluentHasValueAndElement<C, F, ComponentValueChangeEvent<C, Set<I>>, Set<I>>
{

  default F select(I... items)
  {
    get().select(items);
    return (F) this;
  }

  default F deselect(I... items)
  {
    get().deselect(items);
    return (F) this;
  }

  default F select(Iterable<I> items)
  {
    get().select(items);
    return (F) this;
  }

  default F deselect(Iterable<I> items)
  {
    get().deselect(items);
    return (F) this;
  }

  default F updateSelection(Set<I> addedItems, Set<I> removedItems)
  {
    get().updateSelection(addedItems, removedItems);
    return (F) this;
  }

  default F deselectAll()
  {
    get().deselectAll();
    return (F) this;
  }

  default F onSelection(MultiSelectionListener<C, I> listener)
  {
    get().addSelectionListener(listener);
    return (F) this;
  }

}
