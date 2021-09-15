package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.accordion.AccordionPanel;


public class FluentAccordionPanel
  extends FluentDetails
{

  public FluentAccordionPanel()
  {
    super(new AccordionPanel());
  }

  public FluentAccordionPanel(AccordionPanel component)
  {
    super(component);
  }

}
