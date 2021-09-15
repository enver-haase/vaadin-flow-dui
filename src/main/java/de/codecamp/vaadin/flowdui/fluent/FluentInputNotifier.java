package de.codecamp.vaadin.flowdui.fluent;

import java.io.Serializable;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.InputEvent;
import com.vaadin.flow.component.InputNotifier;


@SuppressWarnings("unchecked")
public interface FluentInputNotifier<C extends Component & InputNotifier, F extends FluentInputNotifier<C, F>>
  extends
    FluentHasElement<C, F>,
    Serializable
{

  default F addInputListener(ComponentEventListener<InputEvent> listener)
  {
    getComponent().addInputListener(listener);
    return (F) this;
  }

}
