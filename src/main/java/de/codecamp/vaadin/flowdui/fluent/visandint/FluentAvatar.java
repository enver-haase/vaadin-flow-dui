package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.Avatar.AvatarI18n;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.server.AbstractStreamResource;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentAvatar
  extends FluentComponent<Avatar, FluentAvatar>
  implements
    FluentHasStyle<Avatar, FluentAvatar>,
    FluentHasSize<Avatar, FluentAvatar>,
    FluentHasTheme<Avatar, FluentAvatar>
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
    getComponent().setName(name);
    return this;
  }

  public FluentAvatar abbreviation(String abbr)
  {
    getComponent().setAbbreviation(abbr);
    return this;
  }

  public FluentAvatar colorIndex(Integer colorIndex)
  {
    getComponent().setColorIndex(colorIndex);
    return this;
  }

  public FluentAvatar image(String url)
  {
    getComponent().setImage(url);
    return this;
  }

  public FluentAvatar image(AbstractStreamResource resource)
  {
    getComponent().setImageResource(resource);
    return this;
  }

  public FluentAvatar i18n(AvatarI18n i18n)
  {
    getComponent().setI18n(i18n);
    return this;
  }

  public FluentAvatar themeVariants(AvatarVariant variants)
  {
    getComponent().removeThemeVariants(AvatarVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentAvatar addThemeVariants(AvatarVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentAvatar removeThemeVariants(AvatarVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
