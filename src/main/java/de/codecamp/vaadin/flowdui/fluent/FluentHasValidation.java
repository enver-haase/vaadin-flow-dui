package de.codecamp.vaadin.flowdui.fluent;

import java.io.Serializable;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValidation;


@SuppressWarnings("unchecked")
public interface FluentHasValidation<C extends Component & HasValidation, F extends FluentHasValidation<C, F>>
  extends
    FluentHasElement<C, F>,
    Serializable
{

  default F errorMessage(String errorMessage)
  {
    getComponent().setErrorMessage(errorMessage);
    return (F) this;
  }

  default F invalid(boolean invalid)
  {
    getComponent().setInvalid(invalid);
    return (F) this;
  }

}
