package de.codecamp.vaadin.flowdui.factories;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.googlecode.gentyref.GenericTypeReflector;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateContext;


public class HasValuePostProcessor
  implements ComponentPostProcessor
{

  @Override
  @SuppressWarnings("unchecked")
  public void postProcessComponent(Element element, Component component, TemplateContext context,
      Set<String> consumedAttributes)
  {
    if (component instanceof HasValue)
    {
      HasValue<?, ?> hasValue = (HasValue<?, ?>) component;
      context.readBooleanAttribute(element, "required", hasValue::setRequiredIndicatorVisible,
          consumedAttributes);
      context.readBooleanAttribute(element, "readonly", hasValue::setReadOnly, consumedAttributes);

      Type valueType = GenericTypeReflector.getTypeParameter(component.getClass(),
          HasValue.class.getTypeParameters()[1]);
      if (valueType == Boolean.class)
      {
        context.readBooleanAttribute(element, "value", ((HasValue<?, Boolean>) hasValue)::setValue,
            consumedAttributes);
      }
      else if (valueType == Integer.class)
      {
        context.readIntegerAttribute(element, "value", ((HasValue<?, Integer>) hasValue)::setValue,
            consumedAttributes);
      }
      else if (valueType == Double.class)
      {
        context.readDoubleAttribute(element, "value", ((HasValue<?, Double>) hasValue)::setValue,
            consumedAttributes);
      }
      else if (valueType == BigDecimal.class)
      {
        context.readBigDecimalAttribute(element, "value",
            ((HasValue<?, BigDecimal>) hasValue)::setValue, consumedAttributes);
      }
      else if (valueType == String.class)
      {
        context.readStringAttribute(element, "value", ((HasValue<?, String>) hasValue)::setValue,
            consumedAttributes);
      }
      else if (valueType == LocalDate.class)
      {
        context.readLocalDateAttribute(element, "value",
            ((HasValue<?, LocalDate>) hasValue)::setValue, consumedAttributes);
      }
      else if (valueType == LocalTime.class)
      {
        context.readLocalTimeAttribute(element, "value",
            ((HasValue<?, LocalTime>) hasValue)::setValue, consumedAttributes);
      }
    }
  }

}
