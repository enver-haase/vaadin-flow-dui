package de.codecamp.vaadin.flowdui;

import java.io.Serializable;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.server.VaadinService;


public class Fragment
  implements Serializable
{

  private Class<?> templateHostClass;

  private String templateResourceName;

  private String fragmentId;


  public Fragment(Class<?> templateHostClass, String templateResourceName, String fragmentId)
  {
    this.templateHostClass = templateHostClass;
    this.templateResourceName = templateResourceName;
    this.fragmentId = fragmentId;
  }


  /**
   * Creates a new instance of the template fragment.
   *
   * @param fragmentHost
   *          the optional host object (component or otherwise) that is used for the component
   *          mapping; may be null
   */
  public Component create(Object fragmentHost)
  {
    return VaadinService.getCurrent().getInstantiator().getOrCreate(TemplateBuilder.class)
        .readTemplateFragment(templateHostClass, templateResourceName, fragmentHost, fragmentId);
  }

}
