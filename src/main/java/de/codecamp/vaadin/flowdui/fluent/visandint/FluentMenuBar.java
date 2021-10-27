package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.function.SerializableConsumer;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentMenuBar
  extends FluentComponent<MenuBar, FluentMenuBar>
  implements
    FluentHasMenuItems,
    FluentHasSize<MenuBar, FluentMenuBar>,
    FluentHasStyle<MenuBar, FluentMenuBar>,
    FluentHasTheme<MenuBar, FluentMenuBar>


{

  public FluentMenuBar()
  {
    this(new MenuBar());
  }

  public FluentMenuBar(MenuBar component)
  {
    super(component);
  }


  @Override
  public FluentMenuItem addItem(String text)
  {
    return new FluentMenuItem(get().addItem(text));
  }

  public FluentMenuBar addItem(String text, SerializableConsumer<FluentMenuItem> configurator)
  {
    configurator.accept(addItem(text));
    return this;
  }

  @Override
  public FluentMenuItem addItem(Component component)
  {
    return new FluentMenuItem(get().addItem(component));
  }

  public FluentMenuBar addItem(Component component,
      SerializableConsumer<FluentMenuItem> configurator)
  {
    configurator.accept(addItem(component));
    return this;
  }

}
