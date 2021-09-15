package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.HasAutocapitalize;

import de.codecamp.vaadin.flowdui.fluent.FluentHasElement;


@SuppressWarnings("unchecked")
public interface FluentHasAutocapitalize<C extends HasAutocapitalize, F extends FluentHasAutocapitalize<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F autocapitalize(Autocapitalize autocapitalize)
  {
    getComponent().setAutocapitalize(autocapitalize);
    return (F) this;
  }

}
