package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.details.Details;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class DetailsFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-details":
        Details details = new Details();
        context.readBooleanAttribute(element, "opened", details::setOpened, consumedAttributes);

        context.readChildren(details, element, (slotName, childElement) -> {
          if (slotName == null)
          {
            details.addContent(context.readComponent(childElement, null));
            return true;
          }
          switch (slotName)
          {
            case "summary":
              if (details.getSummary() != null)
              {
                throw new TemplateException(context.getTemplateId(), element,
                    "Only one component for the 'summary' slot supported.");
              }
              details.setSummary(context.readComponentForSlot(childElement, null));
              return true;
            default:
              return false;
          }
        }, textNode -> {
          details.addContent(new Text(textNode.text()));
        });

        return details;
    }

    return null;
  }

}
