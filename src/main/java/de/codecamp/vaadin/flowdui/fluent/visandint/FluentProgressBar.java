package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.progressbar.ProgressBarVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentProgressBar
  extends FluentComponent<ProgressBar, FluentProgressBar>
  implements
    FluentHasSize<ProgressBar, FluentProgressBar>,
    FluentHasStyle<ProgressBar, FluentProgressBar>,
    FluentHasTheme<ProgressBar, FluentProgressBar>,
    FluentHasThemeVariants<ProgressBar, FluentProgressBar, ProgressBarVariant>
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


  @Override
  public FluentProgressBar addThemeVariants(ProgressBarVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentProgressBar removeThemeVariants(ProgressBarVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentProgressBar standard()
  {
    return removeThemeVariants(ProgressBarVariant.LUMO_SUCCESS, ProgressBarVariant.LUMO_ERROR,
        ProgressBarVariant.LUMO_CONTRAST);
  }

  public FluentProgressBar success()
  {
    removeThemeVariants(ProgressBarVariant.LUMO_ERROR, ProgressBarVariant.LUMO_CONTRAST);
    return addThemeVariants(ProgressBarVariant.LUMO_SUCCESS);
  }

  public FluentProgressBar error()
  {
    removeThemeVariants(ProgressBarVariant.LUMO_SUCCESS, ProgressBarVariant.LUMO_CONTRAST);
    return addThemeVariants(ProgressBarVariant.LUMO_ERROR);
  }

  public FluentProgressBar contrast()
  {
    removeThemeVariants(ProgressBarVariant.LUMO_SUCCESS, ProgressBarVariant.LUMO_ERROR);
    return addThemeVariants(ProgressBarVariant.LUMO_CONTRAST);
  }

}
