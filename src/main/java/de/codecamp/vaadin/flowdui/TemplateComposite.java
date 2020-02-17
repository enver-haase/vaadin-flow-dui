package de.codecamp.vaadin.flowdui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.server.VaadinService;


public abstract class TemplateComposite
  extends Composite<Component>
  implements HasSize
{

  private String templateResourceName;


  protected TemplateComposite()
  {
    this(null);
  }

  protected TemplateComposite(String templateResourceName)
  {
    this.templateResourceName = templateResourceName;
  }


  @Override
  protected Component initContent()
  {
    return VaadinService.getCurrent().getInstantiator().getOrCreate(TemplateBuilder.class)
        .readTemplate(this, templateResourceName);
  }

}
