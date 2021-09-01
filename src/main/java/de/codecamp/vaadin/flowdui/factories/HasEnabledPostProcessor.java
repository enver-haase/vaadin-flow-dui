package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasEnabled;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class HasEnabledPostProcessor
  implements
    ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    if (component instanceof HasEnabled)
    {
      HasEnabled hasEnabled = (HasEnabled) component;
      context.readBooleanAttribute(element, "disabled", v -> hasEnabled.setEnabled(!v),
          consumedAttributes);
    }
  }

}
