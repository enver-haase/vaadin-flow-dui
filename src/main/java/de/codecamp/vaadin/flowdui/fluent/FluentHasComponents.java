package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;


@SuppressWarnings("unchecked")
public interface FluentHasComponents<C extends HasComponents, F extends FluentHasComponents<C, F>>
  extends
    FluentHasElement<C, F>,
    FluentHasEnabled<C, F>
{

  default FluentLayoutConfig add(Component... components)
  {
    get().add(components);
    return null;
  }

  default FluentLayoutConfig addAsFirst(Component... children)
  {
    return addAt(0, children);
  }

  default FluentLayoutConfig addAt(int index, Component... children)
  {
    for (int i = 0; i < children.length; i++)
      get().addComponentAtIndex(index + i, children[i]);
    return null;
  }

  default FluentLayoutConfig add(String text)
  {
    get().add(text);
    return null;
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

}
