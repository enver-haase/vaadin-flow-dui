package de.codecamp.vaadin.flowdui.util;

/**
 * Lumo properties related to box shadows.
 *
 * @see <a href="https://vaadin.com/docs/current/themes/lumo/lumo-overview.html">Lumo Theme</a>
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/elevation">Lumo Elevation</a>
 */
public enum LumoBoxShadow
  implements
    LumoProperty
{

  lumoBoxShadowXS("--lumo-box-shadow-xs"),

  lumoBoxShadowS("--lumo-box-shadow-s"),

  lumoBoxShadowM("--lumo-box-shadow-m"),

  lumoBoxShadowL("--lumo-box-shadow-l"),

  lumoBoxShadowXL("--lumo-box-shadow-xl");


  private String property;


  LumoBoxShadow(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }

}
