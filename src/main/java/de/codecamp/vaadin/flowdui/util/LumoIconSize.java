package de.codecamp.vaadin.flowdui.util;

import com.vaadin.flow.component.icon.Icon;


/**
 * Lumo properties related to icon size.
 *
 * @see <a href="https://vaadin.com/docs/current/themes/lumo/lumo-overview.html">Lumo Theme</a>
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/icons">Lumo Icons</a>
 */
public enum LumoIconSize
  implements
    LumoProperty
{

  S("--lumo-icon-size-s"),

  M("--lumo-icon-size-m"),

  L("--lumo-icon-size-l");


  private String property;


  LumoIconSize(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }


  public void applyTo(Icon icon)
  {
    icon.setSize(var());
  }

}
