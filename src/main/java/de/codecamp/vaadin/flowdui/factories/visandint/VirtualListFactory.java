package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.virtuallist.VirtualList;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class VirtualListFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-virtual-list":
        VirtualList<?> virtualList = new VirtualList<>();

        context.readChildren(virtualList, element, null, null);

        return virtualList;
    }

    return null;
  }

}
