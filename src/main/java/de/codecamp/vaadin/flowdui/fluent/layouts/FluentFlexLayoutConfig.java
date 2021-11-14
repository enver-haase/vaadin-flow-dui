package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;


public class FluentFlexLayoutConfig
  extends FluentFlexComponentLayoutConfig
{

  public FluentFlexLayoutConfig(FlexLayout container, Component... children)
  {
    super(container, children);
  }


  @Override
  protected FlexLayout getContainer()
  {
    return (FlexLayout) super.getContainer();
  }

  @Override
  public FluentFlexLayoutConfig expand()
  {
    getContainer().expand(children);
    return this;
  }

  @Override
  public FluentFlexLayoutConfig flexGrow(double flexGrow)
  {
    for (Component child : children)
      getContainer().setFlexGrow(flexGrow, child);
    return this;
  }

  @Override
  public FluentFlexLayoutConfig alignSelf(Alignment alignment)
  {
    for (Component child : children)
      getContainer().setAlignSelf(alignment, child);
    return this;
  }

  public FluentFlexLayoutConfig flexShrink(double flexShrink)
  {
    for (Component child : children)
      getContainer().setFlexShrink(flexShrink, child);
    return this;
  }

  public FluentFlexLayoutConfig flexBasis(String width)
  {
    for (Component child : children)
      getContainer().setFlexBasis(width, child);
    return this;
  }

  public FluentFlexLayoutConfig order(int order)
  {
    for (Component child : children)
      getContainer().setOrder(order, child);
    return this;
  }

}
