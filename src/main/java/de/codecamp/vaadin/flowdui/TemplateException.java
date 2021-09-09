package de.codecamp.vaadin.flowdui;

import org.jsoup.nodes.Element;


public class TemplateException
  extends RuntimeException
{

  private final String templateId;


  public TemplateException(String templateId, String message)
  {
    super(buildMessage(templateId, null, message));
    this.templateId = templateId;
  }

  public TemplateException(String templateId, String message, Throwable cause)
  {
    super(buildMessage(templateId, null, message), cause);
    this.templateId = templateId;
  }

  public TemplateException(String templateId, Element element, String message)
  {
    super(buildMessage(templateId, element, message));
    this.templateId = templateId;
  }

  public TemplateException(String templateId, Element element, String message, Throwable cause)
  {
    super(buildMessage(templateId, element, message), cause);
    this.templateId = templateId;
  }

  private static String buildMessage(String templateId, Element element, String message)
  {
    StringBuilder fullMessage = new StringBuilder();
    fullMessage.append("Error in template '").append(templateId).append("'");

    if (element != null)
    {
      if (element.hasAttr("id"))
        fullMessage.append(" on element with ID'").append(element.attr("id")).append("'");
      else
        fullMessage.append(" on element '").append(element.shallowClone().outerHtml()).append("'");
    }

    fullMessage.append(": ").append(message);

    return fullMessage.toString();
  }


  public String getTemplateId()
  {
    return templateId;
  }

}
