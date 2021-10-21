package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;


@SuppressWarnings("unchecked")
public interface FluentClickNotifier<C extends Component & ClickNotifier<C>, F extends FluentClickNotifier<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F onClick(ComponentEventListener<ClickEvent<C>> listener)
  {
    getComponent().addClickListener(listener);
    return (F) this;
  }

  default F clickShortcut(Key key, KeyModifier... keyModifiers)
  {
    getComponent().addClickShortcut(key, keyModifiers);
    return (F) this;
  }

}
