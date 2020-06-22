package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.select.Select;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class SelectFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-select":
        Select<?> select = new Select<>();
        context.readStringAttribute(element, "label", select::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", select::setPlaceholder,
            consumedAttributes);
        context.readChildren(element, (slotName, childComponent) -> {
          throw new TemplateException(
              "Select cannot be populated using a DUI template. Use its Java API instead.");
        }, null);
        return select;
    }

    return null;
  }

}
