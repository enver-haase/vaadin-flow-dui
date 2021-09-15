package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tabs.Orientation;
import com.vaadin.flow.component.tabs.TabsVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasOrderedComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentTabs
  extends FluentComponent<Tabs, FluentTabs>
  implements
    FluentHasStyle<Tabs, FluentTabs>,
    FluentHasTheme<Tabs, FluentTabs>,
    FluentHasOrderedComponents<Tabs, FluentTabs>,
    FluentHasSize<Tabs, FluentTabs>
{

  public FluentTabs()
  {
    this(new Tabs());
  }

  public FluentTabs(Tabs component)
  {
    super(component);
  }


  public FluentTabs autoselect(boolean autoselect)
  {
    getComponent().setAutoselect(autoselect);
    return this;
  }

  public FluentTabs flexGrowForEnclosedTabs(double flexGrow)
  {
    getComponent().setFlexGrowForEnclosedTabs(flexGrow);
    return this;
  }

  public FluentTabs orientation(Orientation orientation)
  {
    getComponent().setOrientation(orientation);
    return this;
  }

  public FluentTabs selectedIndex(int selectedIndex)
  {
    getComponent().setSelectedIndex(selectedIndex);
    return this;
  }

  public FluentTabs selectedTab(Tab selectedTab)
  {
    getComponent().setSelectedTab(selectedTab);
    return this;
  }

  public FluentTabs add(Tab... tabs)
  {
    getComponent().add(tabs);
    return this;
  }


  public FluentTabs themeVariants(TabsVariant... variants)
  {
    getComponent().removeThemeVariants(TabsVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentTabs addThemeVariants(TabsVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentTabs removeThemeVariants(TabsVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
