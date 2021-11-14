package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;

import de.codecamp.vaadin.flowdui.fluent.FluentHasOrderedComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;


@SuppressWarnings("unchecked")
public interface FluentFlexComponent<C extends Component & FlexComponent, F extends FluentFlexComponent<C, F>>
  extends
    FluentHasOrderedComponents<C, F>,
    FluentHasStyle<C, F>,
    FluentHasSize<C, F>
{

  default F alignItems(Alignment alignment)
  {
    get().setAlignItems(alignment);
    return (F) this;
  }

  default F justifyContent(JustifyContentMode justifyContent)
  {
    get().setJustifyContentMode(justifyContent);
    return (F) this;
  }


  default FluentFlexComponentLayoutConfig configLayoutFor(Component... children)
  {
    return new FluentFlexComponentLayoutConfig(get(), children);
  }

  @Override
  default FluentFlexComponentLayoutConfig add(Component... children)
  {
    get().add(children);
    return new FluentFlexComponentLayoutConfig(get(), children);
  }

  @Override
  default FluentFlexComponentLayoutConfig addAsFirst(Component... children)
  {
    return addAt(0, children);
  }

  @Override
  default FluentFlexComponentLayoutConfig addAt(int index, Component... children)
  {
    for (int i = 0; i < children.length; i++)
      get().addComponentAtIndex(index + i, children[i]);
    return new FluentFlexComponentLayoutConfig(get(), children);
  }

  @Override
  default FluentFlexComponentLayoutConfig replace(Component oldChild, Component newChild)
  {
    get().replace(oldChild, newChild);
    return new FluentFlexComponentLayoutConfig(get(), newChild);
  }

}
