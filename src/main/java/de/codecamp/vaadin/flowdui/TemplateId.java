package de.codecamp.vaadin.flowdui;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Used to annotate subclasses of {@link TemplateComposite} in order to override the default
 * template ID. The default template ID is the fully qualified name of the class.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface TemplateId
{

  /**
   * Returns the ID of the template to be loaded.
   *
   * @return the ID of the template to be loaded
   */
  String value();

}
