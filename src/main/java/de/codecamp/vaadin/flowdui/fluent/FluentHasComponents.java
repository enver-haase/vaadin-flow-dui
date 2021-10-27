package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;


@SuppressWarnings("unchecked")
public interface FluentHasComponents<C extends HasComponents, F extends FluentHasComponents<C, F>>
  extends
    FluentHasElement<C, F>,
    FluentHasEnabled<C, F>
{

  default F add(Component... components)
  {
    get().add(components);
    return (F) this;
  }

  default F add(String text)
  {
    get().add(text);
    return (F) this;
  }

  default F remove(Component... components)
  {
    get().remove(components);
    return (F) this;
  }

  default F removeAll()
  {
    get().removeAll();
    return (F) this;
  }

  default F addAt(int index, Component component)
  {
    get().addComponentAtIndex(index, component);
    return (F) this;
  }

  default F addAsFirst(Component component)
  {
    get().addComponentAsFirst(component);
    return (F) this;
  }

}
