package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.HasAutocomplete;

import de.codecamp.vaadin.flowdui.fluent.FluentHasElement;


@SuppressWarnings("unchecked")
public interface FluentHasAutocomplete<C extends HasAutocomplete, F extends FluentHasAutocomplete<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F autocomplete(Autocomplete autocomplete)
  {
    getComponent().setAutocomplete(autocomplete);
    return (F) this;
  }

}
