package de.codecamp.vaadin.flowdui.components;

public enum BadgeVariant
{

  LUMO_SUCCESS("success"),
  LUMO_ERROR("error"),
  LUMO_CONTRAST("contrast"),

  LUMO_PRIMARY("primary"),

  LUMO_SMALL("small"),

  LUMO_PILL("pill");


  private final String variant;


  BadgeVariant(String variant)
  {
    this.variant = variant;
  }

  /**
   * Gets the variant name.
   *
   * @return variant name
   */
  public String getVariantName()
  {
    return variant;
  }

}
