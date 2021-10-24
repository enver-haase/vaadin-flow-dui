package de.codecamp.vaadin.flowdui.util;

/**
 * Lumo properties related to line height.
 *
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/typography">Lumo Typography</a>
 */
public enum LumoLineHeight
  implements
    LumoProperty
{

  XS("--lumo-line-height-xs"),

  S("--lumo-line-height-s"),

  M("--lumo-line-height-m");


  private String property;


  LumoLineHeight(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }

}
