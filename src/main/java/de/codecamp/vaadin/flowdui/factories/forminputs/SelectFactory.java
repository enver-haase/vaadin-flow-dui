package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.select.Select;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class SelectFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-select":
        Select<?> select = new Select<>();
        context.readStringAttribute(element, "label", select::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", select::setPlaceholder,
            consumedAttributes);
        context.readChildren(select, element, (slotName, childComponent) -> {
          throw new TemplateException(
              "Select cannot be populated using a template. Use its Java API instead.");
        }, null);
        return select;
    }

    return null;
  }

}
