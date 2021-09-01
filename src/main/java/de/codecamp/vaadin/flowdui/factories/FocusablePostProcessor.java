package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class FocusablePostProcessor
  implements
    ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    if (component instanceof Focusable)
    {
      Focusable<?> focusable = (Focusable<?>) component;

      context.readIntegerAttribute(element, "tabindex", focusable::setTabIndex, consumedAttributes);
    }
  }

}
