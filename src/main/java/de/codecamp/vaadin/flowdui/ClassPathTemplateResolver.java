package de.codecamp.vaadin.flowdui;

import java.io.InputStream;


public class ClassPathTemplateResolver
  extends AbstractTemplateResolver
{

  @Override
  protected InputStream getInputStream(Class<?> hostClass, String templateId)
  {
    InputStream inputStream = hostClass.getResourceAsStream(templateId + ".html");
    if (inputStream == null)
      inputStream = hostClass.getResourceAsStream(templateId + ".js");
    return inputStream;
  }

}
