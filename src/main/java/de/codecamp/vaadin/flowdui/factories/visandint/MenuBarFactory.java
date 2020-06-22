package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.menubar.MenuBar;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;


public class MenuBarFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-menu-bar":
        MenuBar menuBar = new MenuBar();
        context.readBooleanAttribute(element, "open-on-hover", menuBar::setOpenOnHover,
            consumedAttributes);
        context.readChildren(element, null, null);
        return menuBar;
    }

    return null;
  }

}
