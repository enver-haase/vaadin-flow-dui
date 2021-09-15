package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.HasSize;


@SuppressWarnings("unchecked")
public interface FluentHasSize<C extends HasSize, F extends FluentHasSize<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F width(String width)
  {
    getComponent().setWidth(width);
    return (F) this;
  }

  default F minWidth(String minWidth)
  {
    getComponent().setMinWidth(minWidth);
    return (F) this;
  }

  default F maxWidth(String maxWidth)
  {
    getComponent().setMaxWidth(maxWidth);
    return (F) this;
  }

  default F height(String height)
  {
    getComponent().setHeight(height);
    return (F) this;
  }

  default F minHeight(String minHeight)
  {
    getComponent().setMinHeight(minHeight);
    return (F) this;
  }

  default F maxHeight(String maxHeight)
  {
    getComponent().setMaxHeight(maxHeight);
    return (F) this;
  }

  default F sizeFull()
  {
    getComponent().setSizeFull();
    return (F) this;
  }

  default F widthFull()
  {
    getComponent().setWidthFull();
    return (F) this;
  }

  default F heightFull()
  {
    getComponent().setHeightFull();
    return (F) this;
  }

  default F sizeUndefined()
  {
    getComponent().setSizeUndefined();
    return (F) this;
  }

}
