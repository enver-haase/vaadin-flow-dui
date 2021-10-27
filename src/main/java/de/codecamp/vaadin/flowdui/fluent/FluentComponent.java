package de.codecamp.vaadin.flowdui.fluent;

import static java.util.Objects.requireNonNull;

import com.vaadin.flow.component.Component;


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

}
