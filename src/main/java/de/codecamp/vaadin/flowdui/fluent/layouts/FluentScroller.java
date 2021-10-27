package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.Scroller.ScrollDirection;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;


public class FluentScroller
  extends FluentComponent<Scroller, FluentScroller>
  implements
    FluentHasSize<Scroller, FluentScroller>,
    FluentHasStyle<Scroller, FluentScroller>
{

  public FluentScroller()
  {
    this(new Scroller());
  }

  public FluentScroller(Scroller component)
  {
    super(component);
  }


  public FluentScroller setScrollDirection(ScrollDirection scrollDirection)
  {
    get().setScrollDirection(scrollDirection);
    return this;
  }

  public FluentScroller setContent(Component content)
  {
    get().setContent(content);
    return this;
  }

}
