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
    get().setSummary(summary);
    return this;
  }

  public FluentDetails summaryText(String summary)
  {
    get().setSummaryText(summary);
    return this;
  }

  public FluentDetails content(Component content)
  {
    get().setContent(content);
    return this;
  }

  public FluentDetails opened(boolean opened)
  {
    get().setOpened(opened);
    return this;
  }


  @Override
  public FluentDetails addThemeVariants(DetailsVariant... variants)
  {
    get().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentDetails removeThemeVariants(DetailsVariant... variants)
  {
    get().removeThemeVariants(variants);
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
