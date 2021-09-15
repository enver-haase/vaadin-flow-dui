package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.selection.SingleSelect;


public interface FluentSingleSelect<C extends Component & SingleSelect<C, I>, F extends FluentSingleSelect<C, F, I>, I>
  extends
    FluentHasValueAndElement<C, F, ComponentValueChangeEvent<C, I>, I>
{

}
