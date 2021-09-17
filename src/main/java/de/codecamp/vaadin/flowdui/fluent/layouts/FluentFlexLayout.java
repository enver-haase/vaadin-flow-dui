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
    getComponent().setFlexWrap(flexWrap);
    return this;
  }

  public FluentFlexLayout alignContent(ContentAlignment alignment)
  {
    getComponent().setAlignContent(alignment);
    return this;
  }

  public FluentFlexLayout flexBasis(String width, Component... components)
  {
    getComponent().setFlexBasis(width, components);
    return this;
  }

  public FluentFlexLayout flexDirection(FlexDirection flexDirection)
  {
    getComponent().setFlexDirection(flexDirection);
    return this;
  }

  public FluentFlexLayout flexShrink(double flexShrink, Component... components)
  {
    getComponent().setFlexShrink(flexShrink, components);
    return this;
  }

  public FluentFlexLayout order(int order, Component component)
  {
    getComponent().setOrder(order, component);
    return this;
  }

}