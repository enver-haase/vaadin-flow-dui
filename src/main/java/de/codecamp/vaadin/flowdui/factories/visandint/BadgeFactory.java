package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;
import de.codecamp.vaadin.flowdui.components.Badge;


public class BadgeFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-badge":
        Badge badge = new Badge();

        context.readChildren(badge, element, (slotName, childElement) -> {
          if (slotName != null)
            return false;

          badge.add(context.readComponent(childElement, null));
          return true;
        }, textNode -> {
          badge.setText(textNode.text());
        });
        return badge;
    }
    return null;
  }

}
