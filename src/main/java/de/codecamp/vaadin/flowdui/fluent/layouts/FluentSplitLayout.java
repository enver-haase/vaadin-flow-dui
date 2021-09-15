package de.codecamp.vaadin.flowdui.fluent.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.splitlayout.GeneratedVaadinSplitLayout.SplitterDragendEvent;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout.Orientation;
import com.vaadin.flow.component.splitlayout.SplitLayoutVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentSplitLayout
  extends FluentComponent<SplitLayout, FluentSplitLayout>
  implements
    FluentHasSize<SplitLayout, FluentSplitLayout>,
    FluentHasStyle<SplitLayout, FluentSplitLayout>,
    FluentClickNotifier<SplitLayout, FluentSplitLayout>,
    FluentHasTheme<SplitLayout, FluentSplitLayout>
{

  public FluentSplitLayout()
  {
    this(new SplitLayout());
  }

  public FluentSplitLayout(SplitLayout component)
  {
    super(component);
  }


  public FluentSplitLayout setOrientation(Orientation orientation)
  {
    getComponent().setOrientation(orientation);
    return this;
  }

  public FluentSplitLayout setSplitterPosition(double position)
  {
    getComponent().setSplitterPosition(position);
    return this;
  }

  public FluentSplitLayout primaryComponent(Component component)
  {
    getComponent().addToPrimary(component);
    return this;
  }

  public FluentSplitLayout secondaryComponent(Component component)
  {
    getComponent().addToSecondary(component);
    return this;
  }

  public FluentSplitLayout addSplitterDragendListener(
      ComponentEventListener<SplitterDragendEvent<SplitLayout>> listener)
  {
    getComponent().addSplitterDragendListener(listener);
    return this;
  }

  public FluentSplitLayout themeVariants(SplitLayoutVariant variants)
  {
    getComponent().removeThemeVariants(SplitLayoutVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentSplitLayout addThemeVariants(SplitLayoutVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentSplitLayout removeThemeVariants(SplitLayoutVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
