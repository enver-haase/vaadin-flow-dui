package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValidation;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class HasValidationPostProcessor
  implements ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    if (component instanceof HasValidation)
    {
      HasValidation hasValidation = (HasValidation) component;
      context.readBooleanAttribute(element, "invalid", hasValidation::setInvalid,
          consumedAttributes);
      context.readStringAttribute(element, "error-message", hasValidation::setErrorMessage,
          consumedAttributes);
    }
  }

}
