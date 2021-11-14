package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;


/**
 * Base class for further adapting the layout configuration of a {@link Component} after adding it
 * to a layout.
 * <p>
 * This type has no methods and is only used as a placeholder that can be replaced with a narrower
 * more useful subtype when necessary.
 */
public abstract class FluentLayoutConfig
{

  private final HasComponents container;

  protected final Component[] children;


  protected FluentLayoutConfig(HasComponents container, Component... children)
  {
    this.container = container;
    this.children = children;
  }


  protected HasComponents getContainer()
  {
    return container;
  }

}
