package de.codecamp.vaadin.flowdui;

import java.io.Serializable;

import com.vaadin.flow.component.Component;


public class TemplateFragment
  implements Serializable
{

  private Class<?> templateHostClass;

  private String templateId;

  private String fragmentId;


  public TemplateFragment(Class<?> templateHostClass, String templateId, String fragmentId)
  {
    this.templateHostClass = templateHostClass;
    this.templateId = templateId;
    this.fragmentId = fragmentId;
  }


  /**
   * Creates a new instance of the template fragment, mapped to the given fragment host.
   *
   * @param fragmentHost
   *          the host object (component or otherwise) that is used for the component mapping; may
   *          be null
   * @return the template fragment root
   */
  public Component instantiate(Object fragmentHost)
  {
    return TemplateEngine.get().instantiateTemplateFragment(templateHostClass, templateId,
        fragmentHost, fragmentId);
  }

}
