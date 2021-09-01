package de.codecamp.vaadin.flowdui.factories;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasHelper;

import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class HasHelperPostProcessor
  implements
    ComponentPostProcessor
{

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    if (component instanceof HasHelper)
    {
      HasHelper hasHelper = (HasHelper) component;
      context.readStringAttribute(element, "helper-text", v -> hasHelper.setHelperText(v),
          consumedAttributes);
    }
  }

  @Override
  public boolean handleChildComponent(Component parentComponent, String slotName,
      Element childElement, TemplateParserContext context)
  {
    if (parentComponent instanceof HasHelper)
    {
      HasHelper hasHelper = (HasHelper) parentComponent;
      if ("helper".equals(slotName))
      {
        hasHelper.setHelperComponent(context.readComponentForSlot(childElement, null));
        return true;
      }
    }

    return false;
  }

}
