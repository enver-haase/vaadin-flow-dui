package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.Avatar.AvatarI18n;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.server.AbstractStreamResource;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentAvatar
  extends FluentComponent<Avatar, FluentAvatar>
  implements
    FluentHasSize<Avatar, FluentAvatar>,
    FluentHasStyle<Avatar, FluentAvatar>,
    FluentHasTheme<Avatar, FluentAvatar>,
    FluentHasThemeVariants<Avatar, FluentAvatar, AvatarVariant>
{

  public FluentAvatar()
  {
    this(new Avatar());
  }

  public FluentAvatar(Avatar component)
  {
    super(component);
  }


  public FluentAvatar name(String name)
  {
    get().setName(name);
    return this;
  }

  public FluentAvatar abbreviation(String abbr)
  {
    get().setAbbreviation(abbr);
    return this;
  }

  public FluentAvatar colorIndex(Integer colorIndex)
  {
    get().setColorIndex(colorIndex);
    return this;
  }

  public FluentAvatar image(String url)
  {
    get().setImage(url);
    return this;
  }

  public FluentAvatar image(AbstractStreamResource resource)
  {
    get().setImageResource(resource);
    return this;
  }

  public FluentAvatar i18n(AvatarI18n i18n)
  {
    get().setI18n(i18n);
    return this;
  }

  @Override
  public FluentAvatar addThemeVariants(AvatarVariant... variants)
  {
    get().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentAvatar removeThemeVariants(AvatarVariant... variants)
  {
    get().removeThemeVariants(variants);
    return this;
  }

  public FluentAvatar xsmall()
  {
    removeThemeVariants(AvatarVariant.LUMO_SMALL, AvatarVariant.LUMO_LARGE,
        AvatarVariant.LUMO_XLARGE);
    return addThemeVariants(AvatarVariant.LUMO_XSMALL);
  }

  public FluentAvatar small()
  {
    removeThemeVariants(AvatarVariant.LUMO_XSMALL, AvatarVariant.LUMO_LARGE,
        AvatarVariant.LUMO_XLARGE);
    return addThemeVariants(AvatarVariant.LUMO_SMALL);
  }

  public FluentAvatar medium()
  {
    return removeThemeVariants(AvatarVariant.LUMO_XSMALL, AvatarVariant.LUMO_SMALL,
        AvatarVariant.LUMO_LARGE, AvatarVariant.LUMO_XLARGE);
  }

  public FluentAvatar large()
  {
    removeThemeVariants(AvatarVariant.LUMO_XSMALL, AvatarVariant.LUMO_SMALL,
        AvatarVariant.LUMO_XLARGE);
    return addThemeVariants(AvatarVariant.LUMO_LARGE);
  }

  public FluentAvatar xlarge()
  {
    removeThemeVariants(AvatarVariant.LUMO_XSMALL, AvatarVariant.LUMO_SMALL,
        AvatarVariant.LUMO_LARGE);
    return addThemeVariants(AvatarVariant.LUMO_XLARGE);
  }

}
