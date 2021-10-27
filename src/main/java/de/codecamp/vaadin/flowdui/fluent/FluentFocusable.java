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
    get().setTabIndex(tabIndex);
    return (F) this;
  }

  default F focus()
  {
    get().focus();
    return (F) this;
  }

  default F blur()
  {
    get().blur();
    return (F) this;
  }

  default F focusShortcut(Key key, KeyModifier... keyModifiers)
  {
    get().addFocusShortcut(key, keyModifiers);
    return (F) this;
  }

  default F onBlur(ComponentEventListener<BlurEvent<C>> listener)
  {
    get().addBlurListener(listener);
    return (F) this;
  }

  default F onFocus(ComponentEventListener<FocusEvent<C>> listener)
  {
    get().addFocusListener(listener);
    return (F) this;
  }

}
