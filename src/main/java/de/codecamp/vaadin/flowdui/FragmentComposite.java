package de.codecamp.vaadin.flowdui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;


/**
 * Abstract base class for {@link Composite composites} whose content is created from a fragment of
 * a template.
 *
 * @see TemplateEngine#instantiateTemplateFragment(FragmentComposite)
 * @see Mapped
 * @see Slotted
 */
public abstract class FragmentComposite
  extends Composite<Component>
{

  protected FragmentComposite()
  {
    this(true);
  }

  protected FragmentComposite(boolean createContentEagerly)
  {
    if (createContentEagerly)
      getContent();
  }


  @Override
  protected Component initContent()
  {
    return TemplateEngine.get().instantiateTemplateFragment(this);
  }

}
