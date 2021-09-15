package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.avatar.AvatarGroup;
import com.vaadin.flow.component.avatar.AvatarGroup.AvatarGroupI18n;
import com.vaadin.flow.component.avatar.AvatarGroup.AvatarGroupItem;
import com.vaadin.flow.component.avatar.AvatarGroupVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentAvatarGroup
  extends FluentComponent<AvatarGroup, FluentAvatarGroup>
  implements
    FluentHasStyle<AvatarGroup, FluentAvatarGroup>,
    FluentHasSize<AvatarGroup, FluentAvatarGroup>,
    FluentHasTheme<AvatarGroup, FluentAvatarGroup>
{

  public FluentAvatarGroup()
  {
    this(new AvatarGroup());
  }

  public FluentAvatarGroup(AvatarGroup component)
  {
    super(component);
  }


  public FluentAvatarGroup maxItemsVisible(Integer max)
  {
    getComponent().setMaxItemsVisible(max);
    return this;
  }

  public FluentAvatarGroup items(AvatarGroupItem... items)
  {
    getComponent().setItems(items);
    return this;
  }

  public FluentAvatarGroup add(AvatarGroupItem... items)
  {
    getComponent().add(items);
    return this;
  }

  public FluentAvatarGroup remove(AvatarGroupItem... items)
  {
    getComponent().remove(items);
    return this;
  }

  public FluentAvatarGroup i18n(AvatarGroupI18n i18n)
  {
    getComponent().setI18n(i18n);
    return this;
  }

  public FluentAvatarGroup themeVariants(AvatarGroupVariant variants)
  {
    getComponent().removeThemeVariants(AvatarGroupVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentAvatarGroup addThemeVariants(AvatarGroupVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentAvatarGroup removeThemeVariants(AvatarGroupVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
