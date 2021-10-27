package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValidation;


@SuppressWarnings("unchecked")
public interface FluentHasValidation<C extends Component & HasValidation, F extends FluentHasValidation<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F errorMessage(String errorMessage)
  {
    get().setErrorMessage(errorMessage);
    return (F) this;
  }

  default F invalid(boolean invalid)
  {
    get().setInvalid(invalid);
    return (F) this;
  }

}
