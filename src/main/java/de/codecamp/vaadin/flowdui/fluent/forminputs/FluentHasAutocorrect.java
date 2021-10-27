package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.textfield.HasAutocorrect;

import de.codecamp.vaadin.flowdui.fluent.FluentHasElement;


@SuppressWarnings("unchecked")
public interface FluentHasAutocorrect<C extends HasAutocorrect, F extends FluentHasAutocorrect<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F autocorrect(boolean autocorrect)
  {
    get().setAutocorrect(autocorrect);
    return (F) this;
  }

}
