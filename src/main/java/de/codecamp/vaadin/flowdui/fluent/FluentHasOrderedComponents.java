package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasOrderedComponents;


public interface FluentHasOrderedComponents<C extends Component & HasOrderedComponents, F extends FluentHasOrderedComponents<C, F>>
  extends
    FluentHasComponents<C, F>
{

  default FluentLayoutConfig replace(Component oldComponent, Component newComponent)
  {
    get().replace(oldComponent, newComponent);
    return null;
  }

}
