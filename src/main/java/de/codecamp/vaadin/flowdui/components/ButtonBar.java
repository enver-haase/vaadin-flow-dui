package de.codecamp.vaadin.flowdui.components;

import static de.codecamp.vaadin.flowdui.fluent.Fluent.fluent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import de.codecamp.vaadin.flowdui.fluent.visandint.FluentButton;
import de.codecamp.vaadin.flowdui.util.LumoSpace;


/**
 * The button bar provides a layout for buttons and similar components for forms and dialogs where
 * they can be placed at either end of the bar. {@link #addSpacerToEnd() Spacers} can be added to
 * visually separate certain (groups of) buttons.
 */
public class ButtonBar
  extends Composite<Component>
  implements
    HasSize
{

  private FlexLayout startLayout;

  private FlexLayout endLayout;


  /**
   * Creates a new button bar.
   */
  public ButtonBar()
  {
  }


  @Override
  protected Component initContent()
  {
    startLayout = new FlexLayout();

    endLayout = new FlexLayout();

    FlexLayout content = new FlexLayout(endLayout, startLayout);
    content.setJustifyContentMode(JustifyContentMode.BETWEEN);

    startLayout.getStyle().set("column-gap", LumoSpace.XL.var());
    endLayout.getStyle().set("column-gap", LumoSpace.XL.var());
    content.getStyle().set("column-gap", LumoSpace.XL.var());

    return content;
  }


  /**
   * Adds the given component to the (end of the) start area of the button bar.
   *
   * @param <C>
   *          the component type
   * @param component
   *          the component to add
   * @return the component
   */
  public <C extends Component> C addToStart(C component)
  {
    if (startLayout.getComponentCount() == 0)
      startLayout.add(createGroup());

    FlexComponent group =
        (FlexComponent) startLayout.getComponentAt(startLayout.getComponentCount() - 1);
    group.add(component);

    return component;
  }

  /**
   * Adds a new button to the (end of the) start area of the button bar.
   *
   * @return the new blank button
   */
  public FluentButton addButtonToStart()
  {
    return fluent(addToStart(new Button()));
  }

  /**
   * Adds a spacer to the (end of the) start area of the button bar. Further components will be
   * added to the next button group.
   */
  public void addSpacerToStart()
  {
    startLayout.add(createGroup());
  }

  /**
   * Adds the given component to the (end of the) end area of the button bar.
   *
   * @param <C>
   *          the component type
   * @param component
   *          the component to add
   * @return the component
   */
  public <C extends Component> C addToEnd(C component)
  {
    if (endLayout.getComponentCount() == 0)
      endLayout.add(createGroup());

    FlexComponent group =
        (FlexComponent) endLayout.getComponentAt(endLayout.getComponentCount() - 1);
    group.add(component);

    return component;
  }

  /**
   * Adds a new button to the (end of the) end area of the button bar.
   *
   * @return the new blank button
   */
  public FluentButton addButtonToEnd()
  {
    return fluent(addToEnd(new Button()));
  }

  /**
   * Adds a spacer to the (end of the) end area of the button bar. Further components will be added
   * to the next button group.
   */
  public void addSpacerToEnd()
  {
    endLayout.add(createGroup());
  }

  private Component createGroup()
  {
    return new HorizontalLayout();
  }

}
