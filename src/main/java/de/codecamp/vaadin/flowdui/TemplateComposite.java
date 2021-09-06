package de.codecamp.vaadin.flowdui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;


/**
 * Abstract base class for {@link Composite composites} whose content is created from a template.
 *
 * @see TemplateEngine#instantiateTemplate(Object)
 * @see Mapped
 * @see Slotted
 */
public abstract class TemplateComposite
  extends Composite<Component>
{

  @Override
  protected Component initContent()
  {
    return TemplateEngine.get().instantiateTemplate(this);
  }

}
