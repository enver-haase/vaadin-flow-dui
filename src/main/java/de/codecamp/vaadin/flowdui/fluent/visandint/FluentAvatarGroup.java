package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.avatar.AvatarGroup;
import com.vaadin.flow.component.avatar.AvatarGroup.AvatarGroupI18n;
import com.vaadin.flow.component.avatar.AvatarGroup.AvatarGroupItem;
import com.vaadin.flow.component.avatar.AvatarGroupVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentAvatarGroup
  extends FluentComponent<AvatarGroup, FluentAvatarGroup>
  implements
    FluentHasSize<AvatarGroup, FluentAvatarGroup>,
    FluentHasStyle<AvatarGroup, FluentAvatarGroup>,
    FluentHasTheme<AvatarGroup, FluentAvatarGroup>,
    FluentHasThemeVariants<AvatarGroup, FluentAvatarGroup, AvatarGroupVariant>
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

  @Override
  public FluentAvatarGroup addThemeVariants(AvatarGroupVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentAvatarGroup removeThemeVariants(AvatarGroupVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentAvatarGroup xsmall()
  {
    removeThemeVariants(AvatarGroupVariant.LUMO_SMALL, AvatarGroupVariant.LUMO_LARGE,
        AvatarGroupVariant.LUMO_XLARGE);
    return addThemeVariants(AvatarGroupVariant.LUMO_XSMALL);
  }

  public FluentAvatarGroup small()
  {
    removeThemeVariants(AvatarGroupVariant.LUMO_XSMALL, AvatarGroupVariant.LUMO_LARGE,
        AvatarGroupVariant.LUMO_XLARGE);
    return addThemeVariants(AvatarGroupVariant.LUMO_SMALL);
  }

  public FluentAvatarGroup medium()
  {
    return removeThemeVariants(AvatarGroupVariant.LUMO_XSMALL, AvatarGroupVariant.LUMO_SMALL,
        AvatarGroupVariant.LUMO_LARGE, AvatarGroupVariant.LUMO_XLARGE);
  }

  public FluentAvatarGroup large()
  {
    removeThemeVariants(AvatarGroupVariant.LUMO_XSMALL, AvatarGroupVariant.LUMO_SMALL,
        AvatarGroupVariant.LUMO_XLARGE);
    return addThemeVariants(AvatarGroupVariant.LUMO_LARGE);
  }

  public FluentAvatarGroup xlarge()
  {
    removeThemeVariants(AvatarGroupVariant.LUMO_XSMALL, AvatarGroupVariant.LUMO_SMALL,
        AvatarGroupVariant.LUMO_LARGE);
    return addThemeVariants(AvatarGroupVariant.LUMO_XLARGE);
  }

}
