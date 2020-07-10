package de.codecamp.vaadin.flowdui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.server.VaadinService;


/**
 * A {@link Composite composite} whose content is created from a DUI template.
 *
 * @see Mapped
 * @see Slotted
 */
public abstract class TemplateComposite
  extends Composite<Component>
  implements HasSize
{

  private String templateResourceName;


  /**
   * Creates the template composite using the default resource name for the template.
   *
   * @see #TemplateComposite(String)
   */
  protected TemplateComposite()
  {
    this(null);
  }

  /**
   * Creates the template composite using the given resource name for the template.
   *
   * @param templateResourceName
   *          the resource name of the template file to load; if empty the name will be assumed to
   *          be the same as the simple name of the component class with an {@code .html} ending in
   *          the same directory/package as the class
   */
  // TODO this constructor prevents validation in annotation processor
  protected TemplateComposite(String templateResourceName)
  {
    this.templateResourceName = templateResourceName;
  }


  @Override
  protected Component initContent()
  {
    return VaadinService.getCurrent().getInstantiator().getOrCreate(TemplateBuilder.class)
        .readTemplate(this, templateResourceName);
  }

}
