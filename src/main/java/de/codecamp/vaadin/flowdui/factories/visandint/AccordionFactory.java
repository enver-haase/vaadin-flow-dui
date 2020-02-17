package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class AccordionFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-accordion":
        Accordion accordion = new Accordion();
        context.readBooleanAttribute(element, TemplateContext.CUSTOM_ATTR_PREFIX + "closed",
            v -> accordion.close(), consumedAttributes);
        context.readChildren(element, (slotName, childElement) -> {
          if (slotName != null)
            return false;

          if (!childElement.tagName().equals("vaadin-accordion-panel"))
          {
            throw new TemplateException(
                "Accordion only supports AccordionPanel as child component.");
          }

          AccordionPanel accordionPanel =
              (AccordionPanel) context.readComponent(childElement, null);
          accordion.add(accordionPanel);
          return true;
        }, null);
        return accordion;

      case "vaadin-accordion-panel":
        AccordionPanel panel = new AccordionPanel();
        context.readChildren(element, (slotName, childElement) -> {
          if (slotName == null)
          {
            panel.addContent(context.readComponent(childElement, null));
            return true;
          }
          switch (slotName)
          {
            case "summary":
              if (panel.getSummary() != null)
              {
                throw new TemplateException(element,
                    "Only one component for the 'summary' slot supported.");
              }
              panel.setSummary(context.readComponentForSlot(childElement, null));
              return true;
            default:
              return false;
          }
        }, textNode -> {
          panel.addContent(new Text(textNode.text()));
        });
        return panel;
    }

    return null;
  }

}
