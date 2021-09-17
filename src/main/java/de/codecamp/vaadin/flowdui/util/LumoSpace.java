package de.codecamp.vaadin.flowdui.util;

/**
 * Lumo properties related to spacing.
 *
 * @see <a href="https://vaadin.com/docs/current/themes/lumo/lumo-overview.html">Lumo Theme</a>
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/size-space">Lumo Size and Space</a>
 */
public enum LumoSpace
  implements
    LumoProperty
{

  XS("--lumo-space-xs"),

  S("--lumo-space-s"),

  M("--lumo-space-m"),

  L("--lumo-space-l"),

  XL("--lumo-space-xl"),


  WideXS("--lumo-space-wide-xs"),

  WideS("--lumo-space-wide-s"),

  WideM("--lumo-space-wide-m"),

  WideL("--lumo-space-wide-l"),

  WideXL("--lumo-space-wide-xl"),


  TallXS("--lumo-space-tall-xs"),

  TallS("--lumo-space-tall-s"),

  TallM("--lumo-space-tall-m"),

  TallL("--lumo-space-tall-l"),

  TallXL("--lumo-space-tall-xl");


  private String property;


  LumoSpace(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }

}
