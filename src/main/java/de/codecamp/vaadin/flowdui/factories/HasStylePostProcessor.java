package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateContext;


public class HasStylePostProcessor
  implements ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Element element, Component component, TemplateContext context,
      Set<String> consumedAttributes)
  {
    if (component instanceof HasStyle)
    {
      HasStyle hasStyle = (HasStyle) component;

      context.readStringAttribute(element, "class", hasStyle::setClassName, consumedAttributes);

      context.readStringAttribute(element, "style", v -> {
        for (String propertyString : v.split(";"))
        {
          String[] propertyTokens = propertyString.trim().split(":", 2);
          String property = propertyTokens[0];
          String value = propertyTokens[1];

          hasStyle.getStyle().set(property, value);
        }
      }, consumedAttributes);
    }
  }

}
