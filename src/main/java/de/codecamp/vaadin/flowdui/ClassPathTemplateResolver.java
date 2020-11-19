package de.codecamp.vaadin.flowdui;

import java.io.InputStream;


public class ClassPathTemplateResolver
  extends AbstractTemplateResolver
{

  @Override
  protected InputStream getInputStream(Class<?> hostClass, String templateId)
  {
    String resourcePath = "/" + templateId.replace(".", "/");
    InputStream inputStream = hostClass.getResourceAsStream(resourcePath + ".html");
    if (inputStream == null)
      inputStream = hostClass.getResourceAsStream(resourcePath + ".js");
    return inputStream;
  }

}
