package de.codecamp.vaadin.flowdui.util;

/**
 * Lumo properties related to color.
 *
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation/color">Lumo Color</a>
 */
public enum LumoColor
  implements
    LumoProperty
{

  baseColor("--lumo-base-color"),


  contrast5Pct("--lumo-contrast-5pct"),

  contrast10Pct("--lumo-contrast-10pct"),

  contrast20Pct("--lumo-contrast-20pct"),

  contrast30Pct("--lumo-contrast-30pct"),

  contrast40Pct("--lumo-contrast-40pct"),

  contrast50Pct("--lumo-contrast-50pct"),

  contrast60Pct("--lumo-contrast-60pct"),

  contrast70Pct("--lumo-contrast-70pct"),

  contrast80Pct("--lumo-contrast-80pct"),

  contrast90Pct("--lumo-contrast-90pct"),

  contrast("--lumo-contrast"),


  primaryColor10Pct("--lumo-primary-color-10pct"),

  primaryColor50Pct("--lumo-primary-color-50pct"),

  primaryColor("--lumo-primary-color"),

  primaryTextColor("--lumo-primary-text-color"),

  primaryContrastColor("--lumo-primary-contrast-color"),


  errorColor10Pct("--lumo-error-color-10pct"),

  errorColor50Pct("--lumo-error-color-50pct"),

  errorColor("--lumo-error-color"),

  errorTextColor("--lumo-error-text-color"),

  errorContrastColor("--lumo-error-contrast-color"),


  successColor10Pct("--lumo-success-color-10pct"),

  successColor50Pct("--lumo-success-color-50pct"),

  successColor("--lumo-success-color"),

  successTextColor("--lumo-success-text-color"),

  successContrastColor("--lumo-success-contrast-color"),


  headerTextColor("--lumo-header-text-color"),

  bodyTextColor("--lumo-body-text-color"),

  secondaryTextColor("--lumo-secondary-text-color"),

  tertiaryTextColor("--lumo-tertiary-text-color"),

  disabledTextColor("--lumo-disabled-text-color");



  private String property;


  LumoColor(String property)
  {
    this.property = property;
  }


  @Override
  public String property()
  {
    return property;
  }

}
