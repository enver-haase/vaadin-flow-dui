package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class BasicFlowPostProcessor
  implements ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    context.readStringAttribute(element, "id", component::setId, consumedAttributes);

    context.readBooleanAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "hidden",
        v -> component.setVisible(!v), consumedAttributes);

    context.copyAttribute(element, "aria-label", component, consumedAttributes);
    context.copyAttribute(element, "aria-labelledby", component, consumedAttributes);
    context.copyAttribute(element, "aria-describedby", component, consumedAttributes);
  }

}
