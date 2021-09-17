package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;

import de.codecamp.vaadin.flowdui.fluent.FluentHasOrderedComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;


@SuppressWarnings("unchecked")
public interface FluentFlexComponent<C extends Component & FlexComponent, F extends FluentFlexComponent<C, F>>
  extends
    FluentHasOrderedComponents<C, F>,
    FluentHasStyle<C, F>,
    FluentHasSize<C, F>
{

  default F alignItems(Alignment alignment)
  {
    getComponent().setAlignItems(alignment);
    return (F) this;
  }

  default F alignSelf(Alignment alignment, Component... components)
  {
    getComponent().setAlignSelf(alignment, components);
    return (F) this;
  }

  default F flexGrow(double flexGrow, Component... components)
  {
    getComponent().setFlexGrow(flexGrow, components);
    return (F) this;
  }

  default F justifyContent(JustifyContentMode justifyContent)
  {
    getComponent().setJustifyContentMode(justifyContent);
    return (F) this;
  }

  default F expand(Component... components)
  {
    getComponent().expand(components);
    return (F) this;
  }

  default F add(Component component, Alignment alignSelf, double flexGrow)
  {
    getComponent().add(component);
    getComponent().setAlignSelf(alignSelf, component);
    getComponent().setFlexGrow(flexGrow, component);
    return (F) this;
  }

}
