package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;


public class FluentFlexLayout
  extends FluentComponent<FlexLayout, FluentFlexLayout>
  implements
    FluentFlexComponent<FlexLayout, FluentFlexLayout>,
    FluentClickNotifier<FlexLayout, FluentFlexLayout>
{

  public FluentFlexLayout()
  {
    this(new FlexLayout());
  }

  public FluentFlexLayout(FlexLayout component)
  {
    super(component);
  }


  public FluentFlexLayout flexWrap(FlexWrap flexWrap)
  {
    get().setFlexWrap(flexWrap);
    return this;
  }

  public FluentFlexLayout alignContent(ContentAlignment alignment)
  {
    get().setAlignContent(alignment);
    return this;
  }

  public FluentFlexLayout flexDirection(FlexDirection flexDirection)
  {
    get().setFlexDirection(flexDirection);
    return this;
  }


  @Override
  public FluentFlexLayoutConfig configLayoutFor(Component... children)
  {
    return new FluentFlexLayoutConfig(get(), children);
  }

  @Override
  public FluentFlexLayoutConfig add(Component... children)
  {
    get().add(children);
    return new FluentFlexLayoutConfig(get(), children);
  }

  @Override
  public FluentFlexLayoutConfig addAsFirst(Component... children)
  {
    return addAt(0, children);
  }

  @Override
  public FluentFlexLayoutConfig addAt(int index, Component... children)
  {
    for (int i = 0; i < children.length; i++)
      get().addComponentAtIndex(index + i, children[i]);
    return new FluentFlexLayoutConfig(get(), children);
  }

  @Override
  public FluentFlexLayoutConfig replace(Component oldChild, Component newChild)
  {
    get().replace(oldChild, newChild);
    return new FluentFlexLayoutConfig(get(), newChild);
  }

}
