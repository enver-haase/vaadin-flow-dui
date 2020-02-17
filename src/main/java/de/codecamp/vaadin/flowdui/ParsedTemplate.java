package de.codecamp.vaadin.flowdui;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;


public class ParsedTemplate
{

  private Component rootComponent;

  private Map<String, Component> idToComponent = new HashMap<>();


  public ParsedTemplate(Component rootComponent, Map<String, Component> idToComponent)
  {
    this.rootComponent = rootComponent;
    this.idToComponent = idToComponent;
  }


  public Component getComponentById(String id)
  {
    return idToComponent.get(id);
  }

  public Component getRootComponent()
  {
    return rootComponent;
  }

}
