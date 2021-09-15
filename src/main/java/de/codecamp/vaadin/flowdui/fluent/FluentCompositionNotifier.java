package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.CompositionEndEvent;
import com.vaadin.flow.component.CompositionNotifier;
import com.vaadin.flow.component.CompositionStartEvent;
import com.vaadin.flow.component.CompositionUpdateEvent;


@SuppressWarnings("unchecked")
public interface FluentCompositionNotifier<C extends Component & CompositionNotifier, F extends FluentCompositionNotifier<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F addCompositionStartListener(ComponentEventListener<CompositionStartEvent> listener)
  {
    getComponent().addCompositionStartListener(listener);
    return (F) this;
  }

  default F addCompositionUpdateListener(ComponentEventListener<CompositionUpdateEvent> listener)
  {
    getComponent().addCompositionUpdateListener(listener);
    return (F) this;
  }

  default F addCompositionEndListener(ComponentEventListener<CompositionEndEvent> listener)
  {
    getComponent().addCompositionEndListener(listener);
    return (F) this;
  }

}
