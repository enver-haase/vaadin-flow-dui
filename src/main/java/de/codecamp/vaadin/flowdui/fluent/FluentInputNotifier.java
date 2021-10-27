package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.InputEvent;
import com.vaadin.flow.component.InputNotifier;


@SuppressWarnings("unchecked")
public interface FluentInputNotifier<C extends Component & InputNotifier, F extends FluentInputNotifier<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F onInput(ComponentEventListener<InputEvent> listener)
  {
    get().addInputListener(listener);
    return (F) this;
  }

}
