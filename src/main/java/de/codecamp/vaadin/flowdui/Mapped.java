package de.codecamp.vaadin.flowdui;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Used to mark fields to which components from DUI template should be mapped.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Mapped
{

  /**
   * Returns the ID of the component to map to the annotated field. If empty, the field name is used
   * instead.
   *
   * @return the ID of the component to map to the annotated field; the field name is used
   *         otherwise.
   */
  String value() default "";

}
