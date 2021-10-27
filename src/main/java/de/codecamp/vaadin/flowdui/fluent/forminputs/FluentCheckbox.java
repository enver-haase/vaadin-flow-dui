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
    get().setLabel(label);
    return this;
  }

  public FluentCheckbox labelAsHtml(String htmlContent)
  {
    get().setLabelAsHtml(htmlContent);
    return this;
  }

  public FluentCheckbox ariaLabel(String ariaLabel)
  {
    get().setAriaLabel(ariaLabel);
    return this;
  }

  public FluentCheckbox autofocus(boolean autofocus)
  {
    get().setAutofocus(autofocus);
    return this;
  }

  public FluentCheckbox indeterminate(boolean indeterminate)
  {
    get().setIndeterminate(indeterminate);
    return this;
  }

}

