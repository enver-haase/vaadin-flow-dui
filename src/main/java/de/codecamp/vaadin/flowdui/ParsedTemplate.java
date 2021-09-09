package de.codecamp.vaadin.flowdui;

import java.util.Map;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;

import de.codecamp.vaadin.flowdui.components.Slot;


/**
 * Contains the end result of parsing a template, including the root component and information about
 * the encountered component IDs, slots and fragments.
 */
public class ParsedTemplate
{

  private final String templateId;

  private final Component rootComponent;

  private final Map<String, Component> idToComponent;

  private final Map<String, Slot> nameToSlot;

  private final Map<String, Element> idToTemplateFragment;


  public ParsedTemplate(String templateId, Component rootComponent,
      Map<String, Component> idToComponent, Map<String, Slot> nameToSlot,
      Map<String, Element> idToTemplateFragment)
  {
    this.templateId = templateId;
    this.rootComponent = rootComponent;
    this.idToComponent = idToComponent;
    this.nameToSlot = nameToSlot;
    this.idToTemplateFragment = idToTemplateFragment;
  }


  public String getTemplateId()
  {
    return templateId;
  }

  public Component getRootComponent()
  {
    return rootComponent;
  }

  public Component getComponentById(String id)
  {
    return idToComponent.get(id);
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
