package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.icon.IronIcon;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.util.LumoColor;
import de.codecamp.vaadin.flowdui.util.LumoIconSize;


public class FluentIronIcon
  extends FluentComponent<IronIcon, FluentIronIcon>
  implements
    FluentHasStyle<IronIcon, FluentIronIcon>,
    FluentClickNotifier<IronIcon, FluentIronIcon>
{

  public FluentIronIcon(String collection, String icon)
  {
    this(new IronIcon(collection, icon));
  }

  public FluentIronIcon(IronIcon component)
  {
    super(component);
  }


  public FluentIronIcon size(String size)
  {
    getComponent().setSize(size);
    return this;
  }

  public FluentIronIcon size(LumoIconSize size)
  {
    getComponent().setSize(size.var());
    return this;
  }

  public FluentIronIcon sizeS()
  {
    return size(LumoIconSize.S);
  }

  public FluentIronIcon sizeM()
  {
    return size(LumoIconSize.M);
  }

  public FluentIronIcon sizeL()
  {
    return size(LumoIconSize.L);
  }


  public FluentIronIcon color(String color)
  {
    getComponent().setColor(color);
    return this;
  }

  public FluentIronIcon color(LumoColor color)
  {
    getComponent().setColor(color.var());
    return this;
  }

}
