package de.codecamp.vaadin.flowdui;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.components.Slot;


/**
 * Contains the end result of a parsed template, including the root component and information about
 * the encountered component IDs and slots.
 */
public class ParsedTemplate
{

  private Component rootComponent;

  private Map<String, Component> idToComponent = new HashMap<>();

  private Map<String, Slot> nameToSlot = new HashMap<>();


  public ParsedTemplate(Component rootComponent, Map<String, Component> idToComponent,
      Map<String, Slot> nameToSlot)
  {
    this.rootComponent = rootComponent;
    this.idToComponent = idToComponent;
    this.nameToSlot = nameToSlot;
  }


  public Component getComponentById(String id)
  {
    return idToComponent.get(id);
  }

  public Component getRootComponent()
  {
    return rootComponent;
  }

  public Slot getSlotByName(String name)
  {
    return nameToSlot.get(name);
  }

}
