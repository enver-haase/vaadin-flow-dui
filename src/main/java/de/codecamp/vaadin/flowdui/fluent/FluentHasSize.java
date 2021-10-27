package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.HasSize;


@SuppressWarnings("unchecked")
public interface FluentHasSize<C extends HasSize, F extends FluentHasSize<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F width(String width)
  {
    get().setWidth(width);
    return (F) this;
  }

  default F minWidth(String minWidth)
  {
    get().setMinWidth(minWidth);
    return (F) this;
  }

  default F maxWidth(String maxWidth)
  {
    get().setMaxWidth(maxWidth);
    return (F) this;
  }

  default F height(String height)
  {
    get().setHeight(height);
    return (F) this;
  }

  default F minHeight(String minHeight)
  {
    get().setMinHeight(minHeight);
    return (F) this;
  }

  default F maxHeight(String maxHeight)
  {
    get().setMaxHeight(maxHeight);
    return (F) this;
  }

  default F sizeFull()
  {
    get().setSizeFull();
    return (F) this;
  }

  default F widthFull()
  {
    get().setWidthFull();
    return (F) this;
  }

  default F heightFull()
  {
    get().setHeightFull();
    return (F) this;
  }

  default F sizeUndefined()
  {
    get().setSizeUndefined();
    return (F) this;
  }

}
