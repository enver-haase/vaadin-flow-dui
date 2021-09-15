package de.codecamp.vaadin.flowdui.fluent.visandint;

import java.io.Serializable;

import com.vaadin.flow.component.Component;


public interface FluentHasMenuItems
  extends
    Serializable
{

  FluentMenuItem addItem(String text);

  FluentMenuItem addItem(Component component);

}
