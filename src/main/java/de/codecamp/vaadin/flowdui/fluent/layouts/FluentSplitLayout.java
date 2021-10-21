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
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentSplitLayout
  extends FluentComponent<SplitLayout, FluentSplitLayout>
  implements
    FluentHasSize<SplitLayout, FluentSplitLayout>,
    FluentClickNotifier<SplitLayout, FluentSplitLayout>,
    FluentHasStyle<SplitLayout, FluentSplitLayout>,
    FluentHasTheme<SplitLayout, FluentSplitLayout>,
    FluentHasThemeVariants<SplitLayout, FluentSplitLayout, SplitLayoutVariant>
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

  public FluentSplitLayout onSplitterDragend(
      ComponentEventListener<SplitterDragendEvent<SplitLayout>> listener)
  {
    getComponent().addSplitterDragendListener(listener);
    return this;
  }

  @Override
  public FluentSplitLayout addThemeVariants(SplitLayoutVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentSplitLayout removeThemeVariants(SplitLayoutVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentSplitLayout minimal()
  {
    removeThemeVariants(SplitLayoutVariant.LUMO_SMALL);
    return addThemeVariants(SplitLayoutVariant.LUMO_MINIMAL);
  }

  public FluentSplitLayout small()
  {
    removeThemeVariants(SplitLayoutVariant.LUMO_MINIMAL);
    return addThemeVariants(SplitLayoutVariant.LUMO_SMALL);
  }

  public FluentSplitLayout medium()
  {
    return removeThemeVariants(SplitLayoutVariant.LUMO_MINIMAL, SplitLayoutVariant.LUMO_SMALL);
  }

}
