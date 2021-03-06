package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;


public class FluentVerticalLayout
  extends FluentComponent<VerticalLayout, FluentVerticalLayout>
  implements
    FluentThemableLayout<VerticalLayout, FluentVerticalLayout>,
    FluentFlexComponent<VerticalLayout, FluentVerticalLayout>,
    FluentClickNotifier<VerticalLayout, FluentVerticalLayout>
{

  public FluentVerticalLayout()
  {
    super(new VerticalLayout());

    // remove defaults that only exist in the Java API to be consistent with Web Component
    get().setWidth(null);
    get().setPadding(false);
    get().setSpacing(false);
  }

  public FluentVerticalLayout(VerticalLayout component)
  {
    super(component);
  }


  public FluentVerticalLayout horizontalAlignment(Alignment alignment, Component... components)
  {
    get().setHorizontalComponentAlignment(alignment, components);
    return this;
  }

  public FluentVerticalLayout defaultHorizontalAlignment(Alignment alignment)
  {
    get().setDefaultHorizontalComponentAlignment(alignment);
    return this;
  }

}
