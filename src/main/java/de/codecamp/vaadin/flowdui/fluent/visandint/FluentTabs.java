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
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentTabs
  extends FluentComponent<Tabs, FluentTabs>
  implements
    FluentHasOrderedComponents<Tabs, FluentTabs>,
    FluentHasSize<Tabs, FluentTabs>,
    FluentHasStyle<Tabs, FluentTabs>,
    FluentHasTheme<Tabs, FluentTabs>,
    FluentHasThemeVariants<Tabs, FluentTabs, TabsVariant>
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


  @Override
  public FluentTabs addThemeVariants(TabsVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentTabs removeThemeVariants(TabsVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentTabs iconOnTop(boolean enabled)
  {
    return themeVariant(TabsVariant.LUMO_ICON_ON_TOP, enabled);
  }

  public FluentTabs centered(boolean enabled)
  {
    return themeVariant(TabsVariant.LUMO_CENTERED, enabled);
  }

  public FluentTabs minimal()
  {
    removeThemeVariants(TabsVariant.LUMO_SMALL);
    return addThemeVariants(TabsVariant.LUMO_MINIMAL);
  }

  public FluentTabs small()
  {
    removeThemeVariants(TabsVariant.LUMO_MINIMAL);
    return addThemeVariants(TabsVariant.LUMO_SMALL);
  }

  public FluentTabs medium()
  {
    return removeThemeVariants(TabsVariant.LUMO_MINIMAL, TabsVariant.LUMO_SMALL);
  }

  public FluentTabs hideScrollButtons(boolean enabled)
  {
    return themeVariant(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS, enabled);
  }

  public FluentTabs equalWidthTabs(boolean enabled)
  {
    return themeVariant(TabsVariant.LUMO_EQUAL_WIDTH_TABS, enabled);
  }

}
