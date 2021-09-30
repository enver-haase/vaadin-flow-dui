package de.codecamp.vaadin.flowdui.fluent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.googlecode.gentyref.GenericTypeReflector;


class FluentInternalUtils
{

  private static ConcurrentMap<Class<?>, Class<? extends Enum<?>>> THEME_VARIANT_ENUMS =
      new ConcurrentHashMap<>();


  @SuppressWarnings("unchecked")
  static <E extends Enum<E>, F extends FluentHasThemeVariants<?, ?, E>> Class<E> getThemeVariantEnumType(F fluent)
  {
    return (Class<E>) THEME_VARIANT_ENUMS.computeIfAbsent(fluent.getClass(), f -> {
      Class<?> type = GenericTypeReflector.erase(GenericTypeReflector.getTypeParameter(f,
          FluentHasThemeVariants.class.getTypeParameters()[2]));
      if (!Enum.class.isAssignableFrom(type))
        throw new IllegalStateException("Failed to determine type of theme variant enum.");
      return (Class<? extends Enum<?>>) type;
    });
  }

}
