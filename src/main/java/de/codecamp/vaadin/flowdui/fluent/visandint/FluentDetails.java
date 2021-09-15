package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasEnabled;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentDetails
  extends FluentComponent<Details, FluentDetails>
  implements
    FluentHasEnabled<Details, FluentDetails>,
    FluentHasTheme<Details, FluentDetails>
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


  public FluentDetails themeVariants(DetailsVariant variants)
  {
    getComponent().removeThemeVariants(DetailsVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentDetails addThemeVariants(DetailsVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentDetails removeThemeVariants(DetailsVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
