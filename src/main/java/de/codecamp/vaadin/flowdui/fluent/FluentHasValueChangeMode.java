package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.value.HasValueChangeMode;
import com.vaadin.flow.data.value.ValueChangeMode;


@SuppressWarnings("unchecked")
public interface FluentHasValueChangeMode<C extends Component & HasValueChangeMode, F extends FluentHasValueChangeMode<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F setValueChangeMode(ValueChangeMode valueChangeMode)
  {
    get().setValueChangeMode(valueChangeMode);
    return (F) this;
  }

  default F setValueChangeTimeout(int valueChangeTimeout)
  {
    get().setValueChangeTimeout(valueChangeTimeout);
    return (F) this;
  }

}
