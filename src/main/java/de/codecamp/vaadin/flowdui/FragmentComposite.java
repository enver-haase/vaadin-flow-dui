package de.codecamp.vaadin.flowdui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;


public class FragmentComposite
  extends Composite<Component>
{

  private Fragment fragment;


  public FragmentComposite(Fragment fragment)
  {
    super();
    this.fragment = fragment;
  }


  @Override
  protected Component initContent()
  {
    return fragment.create(this);
  }

}
