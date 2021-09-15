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

  default F helperAbove(boolean helperAbove)
  {
    getComponent().getElement().getThemeList()
        .set(TextFieldVariant.LUMO_HELPER_ABOVE_FIELD.getVariantName(), helperAbove);
    return (F) this;
  }

}
