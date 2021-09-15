package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.contextmenu.ContextMenuBase;
import com.vaadin.flow.component.contextmenu.MenuItemBase;
import com.vaadin.flow.component.contextmenu.SubMenuBase;
import com.vaadin.flow.function.SerializableConsumer;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasEnabled;
import de.codecamp.vaadin.flowdui.fluent.FluentHasText;


@SuppressWarnings("unchecked")
abstract class FluentMenuItemBase<C extends MenuItemBase<CMB, C, SMB>, F extends FluentMenuItemBase<C, F, CMB, SMB>, CMB extends ContextMenuBase<CMB, C, SMB>, SMB extends SubMenuBase<CMB, C, SMB>>
  extends FluentComponent<C, F>
  implements
    FluentHasText<C, F>,
    FluentHasComponents<C, F>,
    FluentHasEnabled<C, F>
{

  protected FluentMenuItemBase(C component)
  {
    super(component);
  }


  // FIXME return FluentSubMenu
  public SMB subMenu()
  {
    return getComponent().getSubMenu();
  }

  public F applyToSubMenu(SerializableConsumer<SMB> configurator)
  {
    configurator.accept(getComponent().getSubMenu());
    return (F) this;
  }

  public F checkable(boolean checkable)
  {
    getComponent().setCheckable(checkable);
    return (F) this;
  }

  public F checked(boolean checked)
  {
    getComponent().setChecked(checked);
    return (F) this;
  }

}
