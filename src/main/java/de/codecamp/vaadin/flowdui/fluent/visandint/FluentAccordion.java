package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.Accordion.OpenedChangeEvent;
import com.vaadin.flow.component.accordion.AccordionPanel;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;


public class FluentAccordion
  extends FluentComponent<Accordion, FluentAccordion>
  implements
    FluentHasSize<Accordion, FluentAccordion>
{

  public FluentAccordion()
  {
    this(new Accordion());
  }

  public FluentAccordion(Accordion component)
  {
    super(component);
  }


  public FluentAccordion add(String summary, Component content)
  {
    getComponent().add(summary, content);
    return this;
  }

  public FluentAccordion add(AccordionPanel panel)
  {
    getComponent().add(panel);
    return this;
  }

  public FluentAccordion remove(AccordionPanel panel)
  {
    getComponent().remove(panel);
    return this;
  }

  public FluentAccordion remove(Component content)
  {
    getComponent().remove(content);
    return this;
  }

  public FluentAccordion close()
  {
    getComponent().close();
    return this;
  }

  public FluentAccordion open(int index)
  {
    getComponent().open(index);
    return this;
  }

  public FluentAccordion open(AccordionPanel panel)
  {
    getComponent().open(panel);
    return this;
  }

  public FluentAccordion onOpenedChange(ComponentEventListener<OpenedChangeEvent> listener)
  {
    getComponent().addOpenedChangeListener(listener);
    return this;
  }

}
