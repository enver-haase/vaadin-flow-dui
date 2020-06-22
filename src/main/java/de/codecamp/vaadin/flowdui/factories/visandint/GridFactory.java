package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.treegrid.TreeGrid;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class GridFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-grid":
        Grid<?> grid = new Grid<>();

        context.readChildren(element, (slotName, childComponent) -> {
          throw new TemplateException(
              "Grid cannot be populated using a DUI template. Use its Java API instead.");
        }, null);

        return grid;

      case "vaadin-tree-grid":
        // does not actually exist as a separate component
        TreeGrid<?> treeGrid = new TreeGrid<>();

        context.readChildren(element, (slotName, childComponent) -> {
          throw new TemplateException(
              "TreeGrid cannot be populated using a DUI template. Use its Java API instead.");
        }, null);

        return treeGrid;
    }
    return null;
  }

}
