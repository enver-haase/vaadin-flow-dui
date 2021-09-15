package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasOrderedComponents;


@SuppressWarnings("unchecked")
public interface FluentHasOrderedComponents<C extends Component & HasOrderedComponents<C>, F extends FluentHasOrderedComponents<C, F>>
  extends
    FluentHasComponents<C, F>
{

  default F replace(Component oldComponent, Component newComponent)
  {
    getComponent().replace(oldComponent, newComponent);
    return (F) this;
  }

}
