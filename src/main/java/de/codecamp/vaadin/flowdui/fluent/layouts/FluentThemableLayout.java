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

  default F margin(boolean enabled)
  {
    get().setMargin(enabled);
    return (F) this;
  }

  default F padding(boolean enabled)
  {
    get().setPadding(enabled);
    return (F) this;
  }

  default F spacing(boolean enabled)
  {
    if (enabled)
    {
      return spacing(ThemableLayoutSpacing.M);
    }
    else
    {
      ThemableLayoutSpacing.removeFrom(get());
      return (F) this;
    }
  }

  default F spacing(ThemableLayoutSpacing spacing)
  {
    spacing.applyTo(get());
    return (F) this;
  }

  default F spacingXS()
  {
    return spacing(ThemableLayoutSpacing.XS);
  }

  default F spacingS()
  {
    return spacing(ThemableLayoutSpacing.S);
  }

  default F spacingM()
  {
    return spacing(ThemableLayoutSpacing.M);
  }

  default F spacingL()
  {
    return spacing(ThemableLayoutSpacing.L);
  }

  default F spacingXL()
  {
    return spacing(ThemableLayoutSpacing.XL);
  }

  default F boxSizing(BoxSizing boxSizing)
  {
    get().setBoxSizing(boxSizing);
    return (F) this;
  }

}
