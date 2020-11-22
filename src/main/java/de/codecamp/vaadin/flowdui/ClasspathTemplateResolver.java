package de.codecamp.vaadin.flowdui;

import java.io.InputStream;


/**
 * A classpath-based {@link TemplateResolver}. Resources will be loaded using the given class
 * loader. The template ID is expected to be the fully qualified name of a class; that name will be
 * used as a resource path with several file extensions (.html, .js) in order to find a template.
 */
public class ClasspathTemplateResolver
  extends AbstractTemplateResolver
{

  @Override
  protected InputStream getInputStream(ClassLoader classLoader, String templateId)
  {
    String resourcePath = templateId.replace(".", "/");
    InputStream inputStream = classLoader.getResourceAsStream(resourcePath + ".html");
    if (inputStream == null)
      inputStream = classLoader.getResourceAsStream(resourcePath + ".js");
    return inputStream;
  }

}
