package de.codecamp.vaadin.flowdui;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Used to annotate fragment hosts in order to override the default fragment ID. The default
 * fragment ID is the simple name of the class.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface FragmentId
{

  /**
   * Returns the ID of the fragment to be loaded from the template.
   *
   * @return the ID of the fragment to be loaded from the template
   */
  String value();

}
