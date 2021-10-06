package de.codecamp.vaadin.flowdui.fluent.visandint;

import de.codecamp.vaadin.flowdui.components.Badge;
import de.codecamp.vaadin.flowdui.components.BadgeVariant;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasText;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentBadge
  extends FluentComponent<Badge, FluentBadge>
  implements
    FluentHasComponents<Badge, FluentBadge>,
    FluentHasText<Badge, FluentBadge>,
    FluentHasStyle<Badge, FluentBadge>,
    FluentHasTheme<Badge, FluentBadge>,
    FluentHasThemeVariants<Badge, FluentBadge, BadgeVariant>
{

  public FluentBadge()
  {
    this(new Badge());
  }

  public FluentBadge(Badge component)
  {
    super(component);
  }


  @Override
  public FluentBadge addThemeVariants(BadgeVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentBadge removeThemeVariants(BadgeVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }


  public FluentBadge pill(boolean enabled)
  {
    return themeVariant(BadgeVariant.LUMO_PILL, enabled);
  }


  public FluentBadge small()
  {
    return addThemeVariants(BadgeVariant.LUMO_SMALL);
  }

  public FluentBadge medium()
  {
    return removeThemeVariants(BadgeVariant.LUMO_SMALL);
  }


  public FluentBadge primary()
  {
    return addThemeVariants(BadgeVariant.LUMO_PRIMARY);
  }

  public FluentBadge secondary()
  {
    return removeThemeVariants(BadgeVariant.LUMO_PRIMARY);
  }


  public FluentBadge standard()
  {
    return removeThemeVariants(BadgeVariant.LUMO_SUCCESS, BadgeVariant.LUMO_ERROR,
        BadgeVariant.LUMO_CONTRAST);
  }

  public FluentBadge success()
  {
    removeThemeVariants(BadgeVariant.LUMO_ERROR, BadgeVariant.LUMO_CONTRAST);
    return addThemeVariants(BadgeVariant.LUMO_SUCCESS);
  }

  public FluentBadge error()
  {
    removeThemeVariants(BadgeVariant.LUMO_SUCCESS, BadgeVariant.LUMO_CONTRAST);
    return addThemeVariants(BadgeVariant.LUMO_ERROR);
  }

  public FluentBadge contrast()
  {
    removeThemeVariants(BadgeVariant.LUMO_SUCCESS, BadgeVariant.LUMO_ERROR);
    return addThemeVariants(BadgeVariant.LUMO_CONTRAST);
  }

}
