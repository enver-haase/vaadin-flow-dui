package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

import de.codecamp.vaadin.flowdui.fluent.FluentLayoutConfig;


public class FluentFlexComponentLayoutConfig
  extends FluentLayoutConfig
{

  public FluentFlexComponentLayoutConfig(FlexComponent container, Component... children)
  {
    super(container, children);
  }


  @Override
  protected FlexComponent getContainer()
  {
    return (FlexComponent) super.getContainer();
  }

  public FluentFlexComponentLayoutConfig expand()
  {
    getContainer().expand(children);
    return this;
  }

  public FluentFlexComponentLayoutConfig flexGrow(double flexGrow)
  {
    for (Component child : children)
      getContainer().setFlexGrow(flexGrow, child);
    return this;
  }

  public FluentFlexComponentLayoutConfig alignSelf(Alignment alignment)
  {
    for (Component child : children)
      getContainer().setAlignSelf(alignment, child);
    return this;
  }

}
