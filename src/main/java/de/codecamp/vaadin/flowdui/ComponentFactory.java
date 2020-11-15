package de.codecamp.vaadin.flowdui;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;


/**
 * Component factories are responsible for creating {@link Component components} based on
 * {@link Element HTML elements} parsed from a template.
 */
public interface ComponentFactory
{

  /**
   * Creates a component based on the given element, if the element is supported by this factory.
   *
   * @param element
   *          the HTML element
   * @param context
   *          the parse context of the template
   * @param consumedAttributes
   *          the set of attributes of the element that have so far been consumed to configure the
   *          component; i.e. this method must add all attributes it understands and reads to the
   *          set; methods provided by the {@link TemplateParserContext} will automatically do that
   * @return the created component or null if the given element is not recognized
   */
  Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes);

}
