package de.codecamp.vaadin.flowdui;

import java.io.Serializable;

import org.jsoup.nodes.Element;


@FunctionalInterface
public interface ChildComponentHandler
  extends
    Serializable
{

  boolean handle(String slotName, Element childElement);

}
