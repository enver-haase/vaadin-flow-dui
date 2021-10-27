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
    get().setValue(value);
    return (F) this;
  }

  default F onValueChange(ValueChangeListener<? super E> listener)
  {
    get().addValueChangeListener(listener);
    return (F) this;
  }

  default F clear()
  {
    get().clear();
    return (F) this;
  }

  default F requiredIndicatorVisible(boolean requiredIndicatorVisible)
  {
    get().setRequiredIndicatorVisible(requiredIndicatorVisible);
    return (F) this;
  }

  default F readOnly(boolean readOnly)
  {
    get().setReadOnly(readOnly);
    return (F) this;
  }

}
