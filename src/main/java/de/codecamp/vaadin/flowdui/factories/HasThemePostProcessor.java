package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class HasThemePostProcessor
  implements
    ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    if (component instanceof HasTheme)
    {
      HasTheme hasTheme = (HasTheme) component;

      context.readStringAttribute(element, "theme", hasTheme::setThemeName, consumedAttributes);
    }
  }

}
