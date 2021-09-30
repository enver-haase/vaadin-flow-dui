package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.textfield.TextFieldVariant;


@SuppressWarnings("unchecked")
public interface FluentHasHelper<C extends HasHelper, F extends FluentHasHelper<C, F>>
  extends
    FluentHasElement<C, F>
{

  default F helperText(String helperText)
  {
    getComponent().setHelperText(helperText);
    return (F) this;
  }

  default F helperComponent(Component component)
  {
    getComponent().setHelperComponent(component);
    return (F) this;
  }

  default F helperAboveField(boolean enabled)
  {
    /*
     * The "helper-above-field" variant is supported by components implementing HasHelper. So using
     * the constant from any component should to the trick.
     */
    getComponent().getElement().getThemeList()
        .set(TextFieldVariant.LUMO_HELPER_ABOVE_FIELD.getVariantName(), enabled);
    return (F) this;
  }

}
