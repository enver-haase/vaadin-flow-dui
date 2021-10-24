package de.codecamp.vaadin.flowdui.util;

/**
 * Lumo properties related to border radius.
 *
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/shape">Lumo Shape</a>
 */
public enum LumoBorderRadius
  implements
    LumoProperty
{

  S("--lumo-border-radius-s"),

  M("--lumo-border-radius-m"),

  L("--lumo-border-radius-l");


  private String property;


  LumoBorderRadius(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }

}
