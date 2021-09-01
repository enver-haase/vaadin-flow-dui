package de.codecamp.vaadin.flowdui.factories.pro;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.board.Row;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class BoardFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-board":
        Board board = new Board();
        context.readChildren(board, element, (slotName, childElement) -> {
          if (slotName != null)
            return false;
          board.add(context.readComponent(childElement, null));
          return true;
        }, textNode -> {
          board.add(textNode.text());
        });
        return board;

      case "vaadin-board-row":
        Row row = new Row();
        context.readChildren(row, element, (slotName, childElement) -> {
          if (slotName != null)
            return false;
          row.add(context.readComponent(childElement, null));
          return true;
        }, textNode -> {
          row.add(textNode.text());
        });
        break;

    }

    return null;
  }

}
