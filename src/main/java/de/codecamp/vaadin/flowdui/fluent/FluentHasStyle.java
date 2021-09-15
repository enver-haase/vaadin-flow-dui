package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.function.SerializableConsumer;


@SuppressWarnings("unchecked")
public interface FluentHasStyle<C extends HasStyle, F extends FluentHasStyle<C, F>>
  extends
    FluentHasElement<C, F>
{

  default Style getStyle()
  {
    return getElement().getStyle();
  }

  default F applyToStyle(SerializableConsumer<Style> configurator)
  {
    configurator.accept(getStyle());
    return (F) this;
  }


  default F className(String className, boolean set)
  {
    getComponent().setClassName(className, set);
    return (F) this;
  }

  default F classNames(String... classNames)
  {
    getComponent().setClassName(null);
    getComponent().addClassNames(classNames);
    return (F) this;
  }

  default F addClassNames(String... classNames)
  {
    getComponent().addClassNames(classNames);
    return (F) this;
  }

  default F removeClassNames(String... classNames)
  {
    getComponent().removeClassNames(classNames);
    return (F) this;
  }

}
