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
    get().setAlignItems(alignment);
    return (F) this;
  }

  default F alignSelf(Alignment alignment, Component... components)
  {
    get().setAlignSelf(alignment, components);
    return (F) this;
  }

  default F flexGrow(double flexGrow, Component... components)
  {
    get().setFlexGrow(flexGrow, components);
    return (F) this;
  }

  default F justifyContent(JustifyContentMode justifyContent)
  {
    get().setJustifyContentMode(justifyContent);
    return (F) this;
  }

  default F expand(Component... components)
  {
    get().expand(components);
    return (F) this;
  }

  default F add(Component component, Alignment alignSelf, double flexGrow)
  {
    get().add(component);
    get().setAlignSelf(alignSelf, component);
    get().setFlexGrow(flexGrow, component);
    return (F) this;
  }

}
