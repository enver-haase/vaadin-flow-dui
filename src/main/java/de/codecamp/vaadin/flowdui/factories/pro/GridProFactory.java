package de.codecamp.vaadin.flowdui.factories.pro;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.gridpro.GridPro;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class GridProFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-grid-pro":
        GridPro<?> gridPro = new GridPro<>();

        context.readChildren(element, (slotName, childComponent) -> {
          throw new TemplateException(
              "GridPro cannot be populated using a DUI template. Use its Java API instead.");
        }, null);

        return gridPro;
    }

    return null;
  }

}
