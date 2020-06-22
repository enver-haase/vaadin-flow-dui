package de.codecamp.vaadin.flowdui;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.components.Slot;


/**
 * Contains the end result of a parsed template, including the root component and information about
 * the encountered component IDs and slots.
 */
public class ParsedDuiTemplate
{

  private String templateResourceName;

  private Component rootComponent;

  private Map<String, Component> idToComponent = new HashMap<>();

  private Map<String, Slot> nameToSlot = new HashMap<>();

  private Map<String, Element> idToTemplateFragment = new HashMap<>();


  public ParsedDuiTemplate(String templateResourceName, Component rootComponent,
      Map<String, Component> idToComponent, Map<String, Slot> nameToSlot,
      Map<String, Element> idToTemplateFragment)
  {
    this.templateResourceName = templateResourceName;
    this.rootComponent = rootComponent;
    this.idToComponent = idToComponent;
    this.nameToSlot = nameToSlot;
    this.idToTemplateFragment = idToTemplateFragment;
  }


  public String getTemplateResourceName()
  {
    return templateResourceName;
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

  public Element getTemplateFragmentById(String id)
  {
    return idToTemplateFragment.get(id);
  }

}
