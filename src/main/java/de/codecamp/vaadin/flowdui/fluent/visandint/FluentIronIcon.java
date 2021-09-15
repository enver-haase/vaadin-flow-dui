package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.icon.IronIcon;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;


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

  public FluentIronIcon color(String color)
  {
    getComponent().setColor(color);
    return this;
  }

}
