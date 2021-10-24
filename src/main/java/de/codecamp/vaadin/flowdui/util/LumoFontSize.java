package de.codecamp.vaadin.flowdui.util;

/**
 * Lumo properties related to font size.
 *
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/typography">Lumo Typography</a>
 */
public enum LumoFontSize
  implements
    LumoProperty
{

  XXXL("--lumo-font-size-xxxl"),

  XXL("--lumo-font-size-xxl"),

  XL("--lumo-font-size-xl"),

  L("--lumo-font-size-l"),

  M("--lumo-font-size-m"),

  S("--lumo-font-size-s"),

  XS("--lumo-font-size-xs"),

  XXS("--lumo-font-size-xxs");


  private String property;


  LumoFontSize(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }

}
