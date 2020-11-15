package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class HasSizePostProcessor
  implements ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    if (component instanceof HasSize)
    {
      HasSize hasSize = (HasSize) component;

      context.readBooleanAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "size-full",
          v -> hasSize.setSizeFull(), consumedAttributes);
      context.readBooleanAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "size-auto",
          v -> hasSize.setSizeUndefined(), consumedAttributes);

      context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "width",
          hasSize::setWidth, consumedAttributes);
      context.readBooleanAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "width-full",
          v -> hasSize.setWidthFull(), consumedAttributes);
      context.readBooleanAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "width-auto",
          v -> hasSize.setWidth(null), consumedAttributes);
      context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "min-width",
          hasSize::setMinWidth, consumedAttributes);
      context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "max-width",
          hasSize::setMaxWidth, consumedAttributes);

      context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "height",
          hasSize::setHeight, consumedAttributes);
      context.readBooleanAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "height-full",
          v -> hasSize.setHeightFull(), consumedAttributes);
      context.readBooleanAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "height-auto",
          v -> hasSize.setHeight(null), consumedAttributes);
      context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "min-height",
          hasSize::setMinWidth, consumedAttributes);
      context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "max-height",
          hasSize::setMaxWidth, consumedAttributes);
    }
  }

}
