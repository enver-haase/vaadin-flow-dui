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
   * @param component
   *          the component to be post-processed
   * @param element
   *          the HTML element used to create the component
   * @param context
   *          the parse context of the template
   * @param consumedAttributes
   *          the set of attributes of the element that have so far been consumed to configure the
   *          component; i.e. this method must add all attributes it understands and reads to the
   *          set; methods provided by the {@link TemplateParserContext} will automatically do that
   */
  void postProcessComponent(Component component, Element element, TemplateParserContext context,
      Set<String> consumedAttributes);

  /**
   * Called to handle a child element of a component element in a template. A child element is only
   * handled once, so this method is not guaranteed to be called on all or any post processors.
   *
   * @param parentComponent
   *          the parent component
   * @param slotName
   *          the name of the slot the element is intended for; may be null
   * @param childElement
   *          the child element
   * @param context
   *          the parse context of the template
   * @return whether the child component has been handled; if {@code true} no further
   *         {@link ComponentPostProcessor} is considered
   */
  default boolean handleChildComponent(Component parentComponent, String slotName,
      Element childElement, TemplateParserContext context)
  {
    return false;
  }

}
