package de.codecamp.vaadin.flowdui.fluent;

import java.io.Serializable;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.function.SerializableSupplier;


@SuppressWarnings("unchecked")
public interface FluentHasElement<C extends HasElement, F extends FluentHasElement<C, F>>
  extends
    SerializableSupplier<C>,
    Serializable
{

  default F apply(SerializableConsumer<C> configurator)
  {
    configurator.accept(get());
    return (F) this;
  }


  default Element getElement()
  {
    return ((HasElement) get()).getElement();
  }

  default F applyToElement(SerializableConsumer<Element> configurator)
  {
    configurator.accept(getElement());
    return (F) this;
  }

}
