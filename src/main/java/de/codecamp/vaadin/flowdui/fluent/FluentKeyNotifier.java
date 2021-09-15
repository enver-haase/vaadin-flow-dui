package de.codecamp.vaadin.flowdui.fluent;

import java.io.Serializable;

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
    FluentHasElement<C, F>,
    Serializable
{

  default F addKeyDownListener(ComponentEventListener<KeyDownEvent> listener)
  {
    getComponent().addKeyDownListener(listener);
    return (F) this;
  }

  default F addKeyDownListener(Key key, ComponentEventListener<KeyDownEvent> listener,
      KeyModifier... modifiers)
  {
    return addKeyDownListener(new KeyEventListener<>(listener, key, modifiers));
  }

  default F addKeyUpListener(ComponentEventListener<KeyUpEvent> listener)
  {
    getComponent().addKeyUpListener(listener);
    return (F) this;
  }

  default F addKeyUpListener(Key key, ComponentEventListener<KeyUpEvent> listener,
      KeyModifier... modifiers)
  {
    return addKeyUpListener(new KeyEventListener<>(listener, key, modifiers));
  }

  default F addKeyPressListener(ComponentEventListener<KeyPressEvent> listener)
  {
    getComponent().addKeyPressListener(listener);
    return (F) this;
  }

  default F addKeyPressListener(Key key, ComponentEventListener<KeyPressEvent> listener,
      KeyModifier... modifiers)
  {
    return addKeyPressListener(new KeyEventListener<>(listener, key, modifiers));
  }

}
