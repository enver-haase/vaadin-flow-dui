package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;


public class FluentHorizontalLayout
  extends FluentComponent<HorizontalLayout, FluentHorizontalLayout>
  implements
    FluentThemableLayout<HorizontalLayout, FluentHorizontalLayout>,
    FluentFlexComponent<HorizontalLayout, FluentHorizontalLayout>,
    FluentClickNotifier<HorizontalLayout, FluentHorizontalLayout>
{

  public FluentHorizontalLayout()
  {
    this(new HorizontalLayout());

    // remove defaults that only exist in the Java API to be consistent with Web Component
    get().setSpacing(false);
  }

  public FluentHorizontalLayout(HorizontalLayout component)
  {
    super(component);
  }


  public FluentHorizontalLayout verticalAlignment(Alignment alignment, Component... components)
  {
    get().setVerticalComponentAlignment(alignment, components);
    return this;
  }

  public FluentHorizontalLayout defaultVerticalAlignment(Alignment alignment)
  {
    get().setDefaultVerticalComponentAlignment(alignment);
    return this;
  }

}
