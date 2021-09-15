package de.codecamp.vaadin.flowdui.fluent;

import java.util.Objects;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.function.SerializableSupplier;


@SuppressWarnings("unchecked")
public abstract class FluentComponent<C extends Component, F extends FluentComponent<C, F>>
  implements
    FluentHasElement<C, F>,
    FluentAttachNotifier<C, F>,
    FluentDetachNotifier<C, F>,
    SerializableSupplier<C>
{

  private final C component;


  protected FluentComponent(C component)
  {
    Objects.requireNonNull(component, "component must not be null");
    this.component = component;
  }


  @Override
  public C getComponent()
  {
    return component;
  }

  @Override
  public C get()
  {
    return component;
  }


  public F visible(boolean visible)
  {
    getComponent().setVisible(visible);
    return (F) this;
  }

}
