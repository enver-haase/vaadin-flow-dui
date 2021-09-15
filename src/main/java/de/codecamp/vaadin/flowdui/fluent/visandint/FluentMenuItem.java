package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;


public class FluentMenuItem
  extends FluentMenuItemBase<MenuItem, FluentMenuItem, ContextMenu, SubMenu>
  implements
    FluentClickNotifier<MenuItem, FluentMenuItem>
{

  public FluentMenuItem(MenuItem component)
  {
    super(component);
  }

}
