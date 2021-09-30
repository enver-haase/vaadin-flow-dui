package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasEnabled;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentDetails
  extends FluentComponent<Details, FluentDetails>
  implements
    FluentHasEnabled<Details, FluentDetails>,
    FluentHasStyle<Details, FluentDetails>,
    FluentHasTheme<Details, FluentDetails>,
    FluentHasThemeVariants<Details, FluentDetails, DetailsVariant>
{

  public FluentDetails()
  {
    this(new Details());
  }

  public FluentDetails(Details component)
  {
    super(component);
  }


  public FluentDetails summary(Component summary)
  {
    getComponent().setSummary(summary);
    return this;
  }

  public FluentDetails summaryText(String summary)
  {
    getComponent().setSummaryText(summary);
    return this;
  }

  public FluentDetails content(Component content)
  {
    getComponent().setContent(content);
    return this;
  }

  public FluentDetails opened(boolean opened)
  {
    getComponent().setOpened(opened);
    return this;
  }


  @Override
  public FluentDetails addThemeVariants(DetailsVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentDetails removeThemeVariants(DetailsVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentDetails filled(boolean enabled)
  {
    return themeVariant(DetailsVariant.FILLED, enabled);
  }

  public FluentDetails reverse(boolean enabled)
  {
    return themeVariant(DetailsVariant.REVERSE, enabled);
  }

  public FluentDetails small()
  {
    return addThemeVariants(DetailsVariant.SMALL);
  }

  public FluentDetails medium()
  {
    return removeThemeVariants(DetailsVariant.SMALL);
  }

}
