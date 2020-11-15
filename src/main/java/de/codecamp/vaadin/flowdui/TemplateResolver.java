package de.codecamp.vaadin.flowdui;

import java.util.Optional;

import org.jsoup.nodes.Document;


public interface TemplateResolver
{

  /**
   *
   * @param hostClass
   *          the type to which components of the template will be mapped
   * @param templateId
   * @return the template document if found
   */
  Optional<Document> resolveTemplateDocument(Class<?> hostClass, String templateId);

}
