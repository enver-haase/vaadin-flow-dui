package de.codecamp.vaadin.flowdui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;


public class FragmentComposite
  extends Composite<Component>
{

  private TemplateFragment fragment;


  public FragmentComposite(TemplateFragment fragment)
  {
    this(fragment, true);
  }

  public FragmentComposite(TemplateFragment fragment, boolean createContentEagerly)
  {
    this.fragment = fragment;
    if (createContentEagerly)
      getContent();
  }


  @Override
  protected Component initContent()
  {
    return fragment.instantiate(this);
  }

}
