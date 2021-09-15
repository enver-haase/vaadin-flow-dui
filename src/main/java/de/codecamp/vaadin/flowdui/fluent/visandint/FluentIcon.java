package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;


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
    getComponent().setSize(size);
    return this;
  }

  public FluentIcon color(String color)
  {
    getComponent().setColor(color);
    return this;
  }

}
