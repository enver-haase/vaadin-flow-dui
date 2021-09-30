package de.codecamp.vaadin.flowdui.fluent;

import java.lang.reflect.Array;

import com.vaadin.flow.component.HasElement;


@SuppressWarnings("unchecked")
public interface FluentHasThemeVariants<C extends HasElement, F extends FluentHasThemeVariants<C, F, V>, V extends Enum<V>>
  extends
    FluentHasElement<C, F>
{

  default F themeVariants(V... variants)
  {
    removeThemeVariants(FluentInternalUtils.getThemeVariantEnumType(this).getEnumConstants());
    return addThemeVariants(variants);
  }

  default F themeVariant(V variant, boolean enabled)
  {
    V[] newInstance = (V[]) Array.newInstance(FluentInternalUtils.getThemeVariantEnumType(this), 1);
    newInstance[0] = variant;

    if (enabled)
      return addThemeVariants(newInstance);
    else
      return removeThemeVariants(newInstance);
  }

  F addThemeVariants(V... variants);

  F removeThemeVariants(V... variants);

}
