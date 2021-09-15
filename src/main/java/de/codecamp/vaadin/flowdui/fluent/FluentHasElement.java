package de.codecamp.vaadin.flowdui.fluent;

import java.io.Serializable;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.function.SerializableConsumer;


@SuppressWarnings("unchecked")
public interface FluentHasElement<C extends HasElement, F extends FluentHasElement<C, F>>
  extends
    Serializable
{

  C getComponent();

  default F apply(SerializableConsumer<C> configurator)
  {
    configurator.accept(getComponent());
    return (F) this;
  }


  default Element getElement()
  {
    return ((HasElement) getComponent()).getElement();
  }

  default F applyToElement(SerializableConsumer<Element> configurator)
  {
    configurator.accept(getElement());
    return (F) this;
  }

}
