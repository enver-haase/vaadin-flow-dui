package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;

import de.codecamp.vaadin.flowdui.fluent.FluentHasElement;
import de.codecamp.vaadin.flowdui.util.ThemableLayoutSpacing;


@SuppressWarnings("unchecked")
public interface FluentThemableLayout<C extends ThemableLayout, F extends FluentThemableLayout<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F margin(boolean margin)
  {
    getComponent().setMargin(margin);
    return (F) this;
  }

  default F padding(boolean padding)
  {
    getComponent().setPadding(padding);
    return (F) this;
  }

  default F spacing(boolean spacing)
  {
    getComponent().setSpacing(spacing);
    return (F) this;
  }

  default F spacing(ThemableLayoutSpacing spacing)
  {
    spacing.applyTo(getComponent());
    return (F) this;
  }

  default F boxSizing(BoxSizing boxSizing)
  {
    getComponent().setBoxSizing(boxSizing);
    return (F) this;
  }

}
