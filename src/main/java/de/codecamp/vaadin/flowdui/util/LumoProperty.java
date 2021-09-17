package de.codecamp.vaadin.flowdui.util;

/**
 * Represents a single Lumo property. Can either return the {@link #property() plain property name}
 * or wrapped in a {@link #var() var(...)} function.
 *
 * @see LumoProperties
 */
public interface LumoProperty
{

  /**
   * Returns the name of the Lumo property.
   *
   * @return the name of the Lumo property
   */
  String property();

  /**
   * Returns the Lumo property name surrouned with var(...) function.
   *
   * @return the Lumo property name surrouned with var(...) function
   */
  default String var()
  {
    return "var(" + property() + ")";
  }

}
