package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.AttachNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;


@SuppressWarnings("unchecked")
public interface FluentAttachNotifier<C extends Component & AttachNotifier, F extends FluentAttachNotifier<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F addAttachListener(ComponentEventListener<AttachEvent> listener)
  {
    getComponent().addAttachListener(listener);
    return (F) this;
  }

}
