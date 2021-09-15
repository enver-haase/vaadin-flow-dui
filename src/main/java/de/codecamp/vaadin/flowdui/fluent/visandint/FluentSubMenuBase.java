package de.codecamp.vaadin.flowdui.fluent.visandint;

import java.io.Serializable;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.contextmenu.ContextMenuBase;
import com.vaadin.flow.component.contextmenu.MenuItemBase;
import com.vaadin.flow.component.contextmenu.SubMenuBase;


abstract class FluentSubMenuBase<C extends SubMenuBase<CMB, MIB, C>, F extends FluentSubMenuBase<C, F, MIB, FMIB, CMB>, MIB extends MenuItemBase<CMB, MIB, C>, FMIB extends FluentMenuItemBase<MIB, FMIB, CMB, C>, CMB extends ContextMenuBase<CMB, MIB, C>>
  implements
    Serializable
{

  private C subMenu;


  protected FluentSubMenuBase(C subMenu)
  {
    this.subMenu = subMenu;
  }


  public C getSubMenu()
  {
    return subMenu;
  }


  public abstract FMIB addItem(String text);

  public abstract FMIB addItem(Component component);

  // public void add(Component... components) {
  // getMenuManager().add(components);
  // }
  //
  // public void remove(Component... components) {
  // getMenuManager().remove(components);
  // }
  //
  // public void removeAll() {
  // getMenuManager().removeAll();
  // }
  //
  // public void addComponentAtIndex(int index, Component component) {
  // getMenuManager().addComponentAtIndex(index, component);
  // }

}
