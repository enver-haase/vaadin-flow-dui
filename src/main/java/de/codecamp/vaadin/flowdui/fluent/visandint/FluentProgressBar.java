package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.progressbar.ProgressBarVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentProgressBar
  extends FluentComponent<ProgressBar, FluentProgressBar>
  implements
    FluentHasTheme<ProgressBar, FluentProgressBar>,
    FluentHasStyle<ProgressBar, FluentProgressBar>,
    FluentHasSize<ProgressBar, FluentProgressBar>
{

  public FluentProgressBar()
  {
    this(new ProgressBar());
  }

  public FluentProgressBar(ProgressBar component)
  {
    super(component);
  }


  public FluentProgressBar value(double value)
  {
    getComponent().setValue(value);
    return this;
  }

  public FluentProgressBar max(double max)
  {
    getComponent().setMax(max);
    return this;
  }

  public FluentProgressBar min(double min)
  {
    getComponent().setMin(min);
    return this;
  }

  public FluentProgressBar indeterminate(boolean indeterminate)
  {
    getComponent().setIndeterminate(indeterminate);
    return this;
  }


  public FluentProgressBar themeVariants(ProgressBarVariant variants)
  {
    getComponent().removeThemeVariants(ProgressBarVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentProgressBar addThemeVariants(ProgressBarVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentProgressBar removeThemeVariants(ProgressBarVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
