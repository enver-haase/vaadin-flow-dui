package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.checkbox.Checkbox;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasValueAndElement;


public class FluentCheckbox
  extends FluentComponent<Checkbox, FluentCheckbox>
  implements
    FluentHasSize<Checkbox, FluentCheckbox>,
    FluentHasStyle<Checkbox, FluentCheckbox>,
    FluentFocusable<Checkbox, FluentCheckbox>,
    FluentClickNotifier<Checkbox, FluentCheckbox>,
    FluentHasValueAndElement<Checkbox, FluentCheckbox, ComponentValueChangeEvent<Checkbox, Boolean>, Boolean>
{

  public FluentCheckbox()
  {
    super(new Checkbox());
  }

  public FluentCheckbox(Checkbox component)
  {
    super(component);
  }


  public FluentCheckbox label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentCheckbox labelAsHtml(String htmlContent)
  {
    getComponent().setLabelAsHtml(htmlContent);
    return this;
  }

  public FluentCheckbox ariaLabel(String ariaLabel)
  {
    getComponent().setAriaLabel(ariaLabel);
    return this;
  }

  public FluentCheckbox autofocus(boolean autofocus)
  {
    getComponent().setAutofocus(autofocus);
    return this;
  }

  public FluentCheckbox indeterminate(boolean indeterminate)
  {
    getComponent().setIndeterminate(indeterminate);
    return this;
  }

}

