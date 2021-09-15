package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.HasEnabled;


@SuppressWarnings("unchecked")
public interface FluentHasEnabled<C extends HasEnabled, F extends FluentHasEnabled<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F enabled(boolean enabled)
  {
    getComponent().setEnabled(enabled);
    return (F) this;
  }

}
