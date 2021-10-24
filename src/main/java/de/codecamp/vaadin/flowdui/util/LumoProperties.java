package de.codecamp.vaadin.flowdui.util;

/**
 * The official CSS variables / custom properties provided by the Lumo theme. Where appropriate
 * there's also enums for certain groups of properties.
 *
 * @see <a href="https://vaadin.com/docs/latest/ds/foundation">Foundation</a>
 * @see LumoBorderRadius
 * @see LumoBoxShadow
 * @see LumoColor
 * @see LumoFontSize
 * @see LumoIconSize
 * @see LumoLineHeight
 * @see LumoSize
 * @see LumoSpace
 */
public interface LumoProperties
{

  /*
   * Typography
   *
   * https://vaadin.com/docs/latest/ds/foundation/typography
   */

  LumoProperty lumoFontFamily = new LumoPropertyImpl("--lumo-font-family");


  LumoProperty lumoFontSizeXXXL = LumoFontSize.XXXL;

  LumoProperty lumoFontSizeXXL = LumoFontSize.XXL;

  LumoProperty lumoFontSizeXL = LumoFontSize.XL;

  LumoProperty lumoFontSizeL = LumoFontSize.L;

  LumoProperty lumoFontSizeM = LumoFontSize.M;

  LumoProperty lumoFontSizeS = LumoFontSize.S;

  LumoProperty lumoFontSizeXS = LumoFontSize.XS;

  LumoProperty lumoFontSizeXXS = LumoFontSize.XXS;


  LumoProperty lumoLineHeightM = LumoLineHeight.M;

  LumoProperty lumoLineHeightS = LumoLineHeight.S;

  LumoProperty lumoLineHeightXS = LumoLineHeight.XS;


  /*
   * Color
   *
   * https://vaadin.com/docs/latest/ds/foundation/color
   */

  LumoProperty lumoBaseColor = LumoColor.baseColor;


  LumoProperty lumoContrast5Pct = LumoColor.contrast5Pct;

  LumoProperty lumoContrast10Pct = LumoColor.contrast10Pct;

  LumoProperty lumoContrast20Pct = LumoColor.contrast20Pct;

  LumoProperty lumoContrast30Pct = LumoColor.contrast30Pct;

  LumoProperty lumoContrast40Pct = LumoColor.contrast40Pct;

  LumoProperty lumoContrast50Pct = LumoColor.contrast50Pct;

  LumoProperty lumoContrast60Pct = LumoColor.contrast60Pct;

  LumoProperty lumoContrast70Pct = LumoColor.contrast70Pct;

  LumoProperty lumoContrast80Pct = LumoColor.contrast80Pct;

  LumoProperty lumoContrast90Pct = LumoColor.contrast90Pct;

  LumoProperty lumoContrast = LumoColor.contrast;


  LumoProperty lumoPrimaryColor10Pct = LumoColor.primaryColor10Pct;

  LumoProperty lumoPrimaryColor50Pct = LumoColor.primaryColor50Pct;

  LumoProperty lumoPrimaryColor = LumoColor.primaryColor;

  LumoProperty lumoPrimaryTextColor = LumoColor.primaryTextColor;

  LumoProperty lumoPrimaryContrastColor = LumoColor.primaryContrastColor;


  LumoProperty lumoErrorColor10Pct = LumoColor.errorColor10Pct;

  LumoProperty lumoErrorColor50Pct = LumoColor.errorColor50Pct;

  LumoProperty lumoErrorColor = LumoColor.errorColor;

  LumoProperty lumoErrorTextColor = LumoColor.errorTextColor;

  LumoProperty lumoErrorContrastColor = LumoColor.errorContrastColor;


  LumoProperty lumoSuccessColor10Pct = LumoColor.successColor10Pct;

  LumoProperty lumoSuccessColor50Pct = LumoColor.successColor50Pct;

  LumoProperty lumoSuccessColor = LumoColor.successColor;

  LumoProperty lumoSuccessTextColor = LumoColor.secondaryTextColor;

  LumoProperty lumoSuccessContrastColor = LumoColor.successContrastColor;


  LumoProperty lumoHeaderTextColor = LumoColor.headerTextColor;

  LumoProperty lumoBodyTextColor = LumoColor.bodyTextColor;

  LumoProperty lumoSecondaryTextColor = LumoColor.secondaryTextColor;

  LumoProperty lumoTertiaryTextColor = LumoColor.tertiaryTextColor;

  LumoProperty lumoDisabledTextColor = LumoColor.disabledTextColor;


  /*
   * Size and Space
   *
   * https://vaadin.com/docs/latest/ds/foundation/size-space
   */

  LumoProperty lumoSizeXS = LumoSize.XS;

  LumoProperty lumoSizeS = LumoSize.S;

  LumoProperty lumoSizeM = LumoSize.M;

  LumoProperty lumoSizeL = LumoSize.L;

  LumoProperty lumoSizeXL = LumoSize.XL;


  LumoProperty lumoSpaceXS = LumoSpace.XS;

  LumoProperty lumoSpaceS = LumoSpace.S;

  LumoProperty lumoSpaceM = LumoSpace.M;

  LumoProperty lumoSpaceL = LumoSpace.L;

  LumoProperty lumoSpaceXL = LumoSpace.XL;


  LumoProperty lumoSpaceWideXS = LumoSpace.WideXS;

  LumoProperty lumoSpaceWideS = LumoSpace.WideS;

  LumoProperty lumoSpaceWideM = LumoSpace.WideM;

  LumoProperty lumoSpaceWideL = LumoSpace.WideL;

  LumoProperty lumoSpaceWideXL = LumoSpace.WideXL;


  LumoProperty lumoSpaceTallXS = LumoSpace.TallXS;

  LumoProperty lumoSpaceTallS = LumoSpace.TallS;

  LumoProperty lumoSpaceTallM = LumoSpace.TallM;

  LumoProperty lumoSpaceTallL = LumoSpace.TallL;

  LumoProperty lumoSpaceTallXL = LumoSpace.TallXL;


  /*
   * Shape
   *
   * https://vaadin.com/docs/latest/ds/foundation/shape
   */

  LumoProperty lumoBorderRadiusS = LumoBorderRadius.S;

  LumoProperty lumoBorderRadiusM = LumoBorderRadius.M;

  LumoProperty lumoBorderRadiusL = LumoBorderRadius.L;


  /*
   * Elevation
   *
   * https://vaadin.com/docs/latest/ds/foundation/elevation
   */

  LumoProperty lumoBoxShadowXS = LumoBoxShadow.lumoBoxShadowXS;

  LumoProperty lumoBoxShadowS = LumoBoxShadow.lumoBoxShadowS;

  LumoProperty lumoBoxShadowM = LumoBoxShadow.lumoBoxShadowM;

  LumoProperty lumoBoxShadowL = LumoBoxShadow.lumoBoxShadowL;

  LumoProperty lumoBoxShadowXL = LumoBoxShadow.lumoBoxShadowXL;


  /*
   * Interaction
   *
   * https://vaadin.com/docs/latest/ds/foundation/interaction
   */

  LumoProperty lumoClickableCursor = new LumoPropertyImpl("--lumo-clickable-cursor");


  /*
   * Icons
   *
   * https://vaadin.com/docs/latest/ds/foundation/icons
   */

  LumoProperty lumoIconSizeS = LumoIconSize.S;

  LumoProperty lumoIconSizeM = LumoIconSize.M;

  LumoProperty lumoIconSizeL = LumoIconSize.L;


  /*
   * Misc
   */

  LumoProperty lumoButtonSize = new LumoPropertyImpl("--lumo-button-size");

  LumoProperty lumoTextFieldSize = new LumoPropertyImpl("--lumo-text-field-size");

}
