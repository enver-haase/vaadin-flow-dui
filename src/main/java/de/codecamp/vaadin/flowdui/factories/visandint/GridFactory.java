package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.treegrid.TreeGrid;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class GridFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-grid":
        Grid<?> grid = new Grid<>();

        context.readChildren(grid, element, (slotName, childComponent) -> {
          throw new TemplateException(context.getTemplateId(),
              "Grid cannot be populated using a template. Use its Java API instead.");
        }, null);

        return grid;

      case "vaadin-tree-grid":
        // does not actually exist as a separate component
        TreeGrid<?> treeGrid = new TreeGrid<>();

        context.readChildren(treeGrid, element, (slotName, childComponent) -> {
          throw new TemplateException(context.getTemplateId(),
              "TreeGrid cannot be populated using a template. Use its Java API instead.");
        }, null);

        return treeGrid;
    }
    return null;
  }

}
