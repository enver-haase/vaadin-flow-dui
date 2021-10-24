package de.codecamp.vaadin.flowdui.util;

/**
 * Lumo properties related to size.
 *
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/size-space">Lumo Size and Space</a>
 */
public enum LumoSize
  implements
    LumoProperty
{

  XS("--lumo-size-xs"),

  S("--lumo-size-s"),

  M("--lumo-size-m"),

  L("--lumo-size-l"),

  XL("--lumo-size-xl");


  private String property;


  LumoSize(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }

}
