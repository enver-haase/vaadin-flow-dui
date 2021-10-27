package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.util.LumoColor;
import de.codecamp.vaadin.flowdui.util.LumoIconSize;


public class FluentIcon
  extends FluentComponent<Icon, FluentIcon>
  implements
    FluentHasStyle<Icon, FluentIcon>,
    FluentClickNotifier<Icon, FluentIcon>
{

  public FluentIcon(VaadinIcon icon)
  {
    this(new Icon(icon));
  }

  public FluentIcon(String icon)
  {
    this(new Icon(icon));
  }

  public FluentIcon(Icon component)
  {
    super(component);
  }


  public FluentIcon size(String size)
  {
    get().setSize(size);
    return this;
  }

  public FluentIcon size(LumoIconSize size)
  {
    get().setSize(size.var());
    return this;
  }

  public FluentIcon sizeS()
  {
    return size(LumoIconSize.S);
  }

  public FluentIcon sizeM()
  {
    return size(LumoIconSize.M);
  }

  public FluentIcon sizeL()
  {
    return size(LumoIconSize.L);
  }


  public FluentIcon color(String color)
  {
    get().setColor(color);
    return this;
  }

  public FluentIcon color(LumoColor color)
  {
    get().setColor(color.var());
    return this;
  }

}
