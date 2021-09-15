package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.function.SerializableConsumer;


public class FluentSubMenu
  extends FluentSubMenuBase<SubMenu, FluentSubMenu, MenuItem, FluentMenuItem, ContextMenu>
  implements
    FluentHasMenuItems
{

  public FluentSubMenu(SubMenu subMenu)
  {
    super(subMenu);
  }


  @Override
  public FluentMenuItem addItem(String text)
  {
    return new FluentMenuItem(getSubMenu().addItem(text));
  }

  public FluentSubMenu addItem(String text, SerializableConsumer<FluentMenuItem> configurator)
  {
    configurator.accept(addItem(text));
    return this;
  }


  @Override
  public FluentMenuItem addItem(Component component)
  {
    return new FluentMenuItem(getSubMenu().addItem(component));
  }

}
