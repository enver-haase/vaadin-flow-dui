package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.DetachNotifier;


@SuppressWarnings("unchecked")
public interface FluentDetachNotifier<C extends Component & DetachNotifier, F extends FluentDetachNotifier<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F onDetach(ComponentEventListener<DetachEvent> listener)
  {
    getComponent().addDetachListener(listener);
    return (F) this;
  }

}
