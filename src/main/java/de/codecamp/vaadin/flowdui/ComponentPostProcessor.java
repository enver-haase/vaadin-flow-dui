package de.codecamp.vaadin.flowdui;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;


/**
 * Post processors can make additional modifications to components created by a factory. This is
 * useful e.g. to handle mix-in interfaces like {@link HasSize}.
 */
public interface ComponentPostProcessor
{

  /**
   * Apply this post processor to the given component.
   *
   * @param element
   *          the HTML element used to create the component
   * @param component
   *          the component to be post-processed
   * @param context
   *          the parse context of the template
   * @param consumedAttributes
   *          the set of attribures of the element that have so far been consumed to configure the
   *          component; i.e. this method must add all attributes it understands and reads to the
   *          set; methods provided by the {@link TemplateContext} will automatically do that
   */
  // TODO move Component to the first position
  void postProcessComponent(Element element, Component component, TemplateContext context,
      Set<String> consumedAttributes);

}
