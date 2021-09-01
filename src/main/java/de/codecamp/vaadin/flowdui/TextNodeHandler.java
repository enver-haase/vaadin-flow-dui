package de.codecamp.vaadin.flowdui;

import java.io.Serializable;

import org.jsoup.nodes.TextNode;


@FunctionalInterface
public interface TextNodeHandler
  extends
    Serializable
{

  void handle(TextNode textNode);

}
