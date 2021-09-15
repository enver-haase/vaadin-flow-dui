package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.HasText;


@SuppressWarnings("unchecked")
public interface FluentHasText<C extends HasText, F extends FluentHasText<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F text(String text)
  {
    getComponent().setText(text);
    return (F) this;
  }

}
