package de.codecamp.vaadin.flowdui.fluent;

import static java.util.Objects.requireNonNull;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasOrderedComponents;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import de.codecamp.vaadin.flowdui.fluent.layouts.FluentFlexComponentLayoutConfig;
import de.codecamp.vaadin.flowdui.fluent.layouts.FluentFlexLayoutConfig;


@SuppressWarnings("unchecked")
public abstract class FluentComponent<C extends Component, F extends FluentComponent<C, F>>
  implements
    FluentHasElement<C, F>,
    FluentAttachNotifier<C, F>,
    FluentDetachNotifier<C, F>
{

  private final C component;


  protected FluentComponent(C component)
  {
    this.component = requireNonNull(component, "component must not be null");
  }


  @Override
  public C get()
  {
    return component;
  }


  public F visible(boolean visible)
  {
    get().setVisible(visible);
    return (F) this;
  }


  public void addTo(HasComponents container)
  {
    container.add(get());
  }

  public void addToAsFirst(HasComponents container)
  {
    container.addComponentAsFirst(get());
  }

  public void addToAt(HasComponents container, int index)
  {
    container.addComponentAtIndex(index, get());
  }

  public void replace(HasOrderedComponents container, Component oldComponent)
  {
    container.replace(oldComponent, get());
  }


  public FluentFlexComponentLayoutConfig addTo(FlexComponent container)
  {
    container.add(get());
    return new FluentFlexComponentLayoutConfig(container, get());
  }

  public FluentFlexComponentLayoutConfig addToAsFirst(FlexComponent container)
  {
    container.addComponentAsFirst(get());
    return new FluentFlexComponentLayoutConfig(container, get());
  }

  public FluentFlexComponentLayoutConfig addToAt(FlexComponent container, int index)
  {
    container.addComponentAtIndex(index, get());
    return new FluentFlexComponentLayoutConfig(container, get());
  }

  public FluentFlexComponentLayoutConfig replace(FlexComponent container, Component oldComponent)
  {
    container.replace(oldComponent, get());
    return new FluentFlexComponentLayoutConfig(container, get());
  }


  public FluentFlexLayoutConfig addTo(FlexLayout container)
  {
    container.add(get());
    return new FluentFlexLayoutConfig(container, get());
  }

  public FluentFlexLayoutConfig addToAsFirst(FlexLayout container)
  {
    container.addComponentAsFirst(get());
    return new FluentFlexLayoutConfig(container, get());
  }

  public FluentFlexLayoutConfig addToAt(FlexLayout container, int index)
  {
    container.addComponentAtIndex(index, get());
    return new FluentFlexLayoutConfig(container, get());
  }

  public FluentFlexLayoutConfig replace(FlexLayout container, Component oldComponent)
  {
    container.replace(oldComponent, get());
    return new FluentFlexLayoutConfig(container, get());
  }

}
