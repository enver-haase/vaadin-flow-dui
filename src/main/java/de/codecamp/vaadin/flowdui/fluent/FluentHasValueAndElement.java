package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.HasValueAndElement;


@SuppressWarnings("unchecked")
public interface FluentHasValueAndElement<C extends HasValueAndElement<E, VALUE>, F extends FluentHasValueAndElement<C, F, E, VALUE>, E extends ValueChangeEvent<VALUE>, VALUE>
  extends
    FluentHasElement<C, F>,
    FluentHasEnabled<C, F>
{

  default F value(VALUE value)
  {
    getComponent().setValue(value);
    return (F) this;
  }

  default F addValueChangeListener(ValueChangeListener<? super E> listener)
  {
    getComponent().addValueChangeListener(listener);
    return (F) this;
  }

  default F clear()
  {
    getComponent().clear();
    return (F) this;
  }

  default F requiredIndicatorVisible(boolean requiredIndicatorVisible)
  {
    getComponent().setRequiredIndicatorVisible(requiredIndicatorVisible);
    return (F) this;
  }

  default F readOnly(boolean readOnly)
  {
    getComponent().setReadOnly(readOnly);
    return (F) this;
  }

}
