package de.codecamp.vaadin.flowdui;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;


/**
 * Post processor can make additional modifications to components created by a factory. This is
 * useful e.g. to handle mix-in interfaces like {@link HasSize}.
 */
public interface ComponentPostProcessor
{

  void postProcessComponent(Element element, Component component, TemplateContext context,
      Set<String> consumedAttributes);

}
