package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentTab
  extends FluentComponent<Tab, FluentTab>
  implements
    FluentHasStyle<Tab, FluentTab>,
    FluentHasTheme<Tab, FluentTab>,
    FluentHasComponents<Tab, FluentTab>
{

  public FluentTab()
  {
    this(new Tab());
  }

  public FluentTab(Tab component)
  {
    super(component);
  }


  public FluentTab label(String label)
  {
    getComponent().setLabel(label);
    return this;
  }

  public FluentTab selected(boolean selected)
  {
    getComponent().setSelected(selected);
    return this;
  }

  public FluentTab flexGrow(double flexGrow)
  {
    getComponent().setFlexGrow(flexGrow);
    return this;
  }


  public FluentTab themeVariants(TabVariant... variants)
  {
    getComponent().removeThemeVariants(TabVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentTab addThemeVariants(TabVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentTab removeThemeVariants(TabVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
