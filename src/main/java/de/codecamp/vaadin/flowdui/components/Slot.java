package de.codecamp.vaadin.flowdui.components;

import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Tag;


@Tag("slot")
public class Slot
  extends HtmlContainer
{

  public String getName()
  {
    return getElement().getAttribute("name");
  }

  public void setName(String name)
  {
    getElement().setAttribute("name", name);
  }

}
