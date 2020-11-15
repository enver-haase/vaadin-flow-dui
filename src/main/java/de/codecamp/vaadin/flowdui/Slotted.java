package de.codecamp.vaadin.flowdui;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Used to mark fields that should be inserted into a {@code <slot>} in the template.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Slotted
{

  /**
   * Returns the name of the slot into which the component of the annotated field should be
   * inserted.
   *
   * @return the name of the slot into which the component of the annotated field should be inserted
   */
  String value();

  /**
   * Returns whether the component for the slot is optional.
   *
   * @return whether the component for the slot is optional
   */
  boolean optional() default false;

}
