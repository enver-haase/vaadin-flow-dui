package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.KeyEventListener;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.KeyPressEvent;
import com.vaadin.flow.component.KeyUpEvent;


@SuppressWarnings("unchecked")
public interface FluentKeyNotifier<C extends Component & KeyNotifier, F extends FluentKeyNotifier<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F onKeyDown(ComponentEventListener<KeyDownEvent> listener)
  {
    getComponent().addKeyDownListener(listener);
    return (F) this;
  }

  default F onKeyDown(Key key, ComponentEventListener<KeyDownEvent> listener,
      KeyModifier... modifiers)
  {
    return onKeyDown(new KeyEventListener<>(listener, key, modifiers));
  }

  default F onKeyUp(ComponentEventListener<KeyUpEvent> listener)
  {
    getComponent().addKeyUpListener(listener);
    return (F) this;
  }

  default F onKeyUp(Key key, ComponentEventListener<KeyUpEvent> listener,
      KeyModifier... modifiers)
  {
    return onKeyUp(new KeyEventListener<>(listener, key, modifiers));
  }

  default F onKeyPress(ComponentEventListener<KeyPressEvent> listener)
  {
    getComponent().addKeyPressListener(listener);
    return (F) this;
  }

  default F onKeyPress(Key key, ComponentEventListener<KeyPressEvent> listener,
      KeyModifier... modifiers)
  {
    return onKeyPress(new KeyEventListener<>(listener, key, modifiers));
  }

}
