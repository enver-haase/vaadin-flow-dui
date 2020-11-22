package de.codecamp.vaadin.flowdui;

import java.util.Optional;

import org.jsoup.nodes.Document;


/**
 * Template resolvers are responsible for loading templates based on a provided template ID and
 * return them as {@link Document}.
 */
public interface TemplateResolver
{

  /**
   * Attempts to resolve the template based on the given ID and loads it as {@link Document} when
   * found.
   *
   * @param classLoader
   *          the primary class loader that should be used to load local resources; usually the same
   *          from where the template is used
   * @param templateId
   *          the template ID
   * @return the template document if found
   */
  Optional<Document> resolveTemplateDocument(ClassLoader classLoader, String templateId);

}
