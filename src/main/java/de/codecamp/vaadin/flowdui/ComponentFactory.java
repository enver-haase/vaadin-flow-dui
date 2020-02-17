package de.codecamp.vaadin.flowdui;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;


public interface ComponentFactory
{

  /**
   *
   * @param element
   * @param context
   * @param consumedAttributes
   * @return the created component or null
   */
  Component createComponent(Element element, TemplateContext context,
      Set<String> consumedAttributes);

}
