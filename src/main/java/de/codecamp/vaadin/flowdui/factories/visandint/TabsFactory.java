package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tabs.Orientation;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class TabsFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-tabs":
        Tabs tabs = new Tabs();
        context.readStringAttribute(element, "orientation", v -> {
          if ("vertical".equals(v))
            tabs.setOrientation(Orientation.VERTICAL);
        }, consumedAttributes);

        context.readChildren(tabs, element, (slotName, childElement) -> {
          if (slotName != null)
            return false;
          if (!childElement.tagName().equals("vaadin-tab"))
            throw new TemplateException("Tabs only supports Tab as child component.");

          tabs.add(context.readComponent(childElement, null));
          return true;
        }, null);

        context.readIntegerAttribute(element, "selected", tabs::setSelectedIndex,
            consumedAttributes);
        return tabs;

      case "vaadin-tab":
        Tab tab = new Tab();
        context.readChildren(tab, element, (slotName, childElement) -> {
          if (slotName != null)
            return false;
          tab.add(context.readComponent(childElement, null));
          return true;
        }, textNode -> {
          tab.add(textNode.text());
        });
        return tab;
    }

    return null;
  }

}
