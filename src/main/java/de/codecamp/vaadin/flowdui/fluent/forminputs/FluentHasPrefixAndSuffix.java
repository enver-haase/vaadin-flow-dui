package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.HasPrefixAndSuffix;

import de.codecamp.vaadin.flowdui.fluent.FluentHasElement;


@SuppressWarnings("unchecked")
public interface FluentHasPrefixAndSuffix<C extends HasPrefixAndSuffix, F extends FluentHasPrefixAndSuffix<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F prefixComponent(Component component)
  {
    getComponent().setPrefixComponent(component);
    return (F) this;
  }

  default F suffixComponent(Component component)
  {
    getComponent().setSuffixComponent(component);
    return (F) this;
  }

}
