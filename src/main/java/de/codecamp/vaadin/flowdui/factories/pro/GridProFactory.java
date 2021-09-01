package de.codecamp.vaadin.flowdui.factories.pro;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.gridpro.GridPro;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class GridProFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-grid-pro":
        GridPro<?> gridPro = new GridPro<>();

        context.readChildren(gridPro, element, (slotName, childComponent) -> {
          throw new TemplateException(
              "GridPro cannot be populated using a template. Use its Java API instead.");
        }, null);

        return gridPro;
    }

    return null;
  }

}
