package de.codecamp.vaadin.flowdui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;


/**
 * A {@link Composite composite} whose content is created from a template.
 *
 * @see Mapped
 * @see Slotted
 * @see FragmentId
 */
public abstract class TemplateComposite
  extends Composite<Component>
  implements HasSize
{

  private String templateId;


  /**
   * Creates the template composite using the default template ID.
   *
   * @see #TemplateComposite(String)
   */
  protected TemplateComposite()
  {
    this(null);
  }

  /**
   * Creates the template composite using the given template ID.
   *
   * @param templateId
   *          the ID of the template file to load; if null, the ID will default to the fully
   *          qualified name of this class
   */
  protected TemplateComposite(String templateId)
  {
    if (templateId == null)
      templateId = getClass().getName();
    this.templateId = templateId;
  }


  @Override
  protected Component initContent()
  {
    return TemplateEngine.get().instantiateTemplate(this, templateId);
  }

}
