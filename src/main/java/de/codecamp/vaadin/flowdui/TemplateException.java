package de.codecamp.vaadin.flowdui;

import org.jsoup.nodes.Element;


public class TemplateException
  extends RuntimeException
{

  public TemplateException(String message)
  {
    super(message);
  }

  public TemplateException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public TemplateException(Element element, String message)
  {
    super(buildMessage(element, message));
  }

  public TemplateException(Element element, String message, Throwable cause)
  {
    super(buildMessage(element, message), cause);
  }

  private static String buildMessage(Element element, String message)
  {
    if (element.hasAttr("id"))
      return "Error encountered on element with ID '" + element.attr("id") + "': " + message;
    else
      return "Error encountered on element '" + element.shallowClone().outerHtml() + "': "
          + message;
  }

}
