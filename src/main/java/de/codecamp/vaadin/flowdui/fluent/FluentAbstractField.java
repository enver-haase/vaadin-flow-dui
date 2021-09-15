package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;


public class FluentAbstractField<C extends AbstractField<C, VALUE>, F extends FluentAbstractField<C, F, VALUE>, VALUE>
  extends FluentComponent<C, F>
  implements
    FluentHasValueAndElement<C, F, ComponentValueChangeEvent<C, VALUE>, VALUE>
{

  protected FluentAbstractField(C component)
  {
    super(component);
  }

}
