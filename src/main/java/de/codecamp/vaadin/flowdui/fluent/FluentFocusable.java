package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.BlurNotifier.BlurEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.FocusNotifier.FocusEvent;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;


@SuppressWarnings("unchecked")
public interface FluentFocusable<C extends Component & Focusable<C>, F extends FluentFocusable<C, F>>
  extends
    FluentHasElement<C, F>,
    FluentHasEnabled<C, F>
{

  default F tabIndex(int tabIndex)
  {
    getComponent().setTabIndex(tabIndex);
    return (F) this;
  }

  default F focus()
  {
    getComponent().focus();
    return (F) this;
  }

  default F blur()
  {
    getComponent().blur();
    return (F) this;
  }

  default F addFocusShortcut(Key key, KeyModifier... keyModifiers)
  {
    getComponent().addFocusShortcut(key, keyModifiers);
    return (F) this;
  }

  default F addBlurListener(ComponentEventListener<BlurEvent<C>> listener)
  {
    getComponent().addBlurListener(listener);
    return (F) this;
  }

  default F addFocusListener(ComponentEventListener<FocusEvent<C>> listener)
  {
    getComponent().addFocusListener(listener);
    return (F) this;
  }

}
