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
    get().setAutoselect(autoselect);
    return this;
  }

  public FluentTabs flexGrowForEnclosedTabs(double flexGrow)
  {
    get().setFlexGrowForEnclosedTabs(flexGrow);
    return this;
  }

  public FluentTabs orientation(Orientation orientation)
  {
    get().setOrientation(orientation);
    return this;
  }

  public FluentTabs selectedIndex(int selectedIndex)
  {
    get().setSelectedIndex(selectedIndex);
    return this;
  }

  public FluentTabs selectedTab(Tab selectedTab)
  {
    get().setSelectedTab(selectedTab);
    return this;
  }

  public FluentTabs add(Tab... tabs)
  {
    get().add(tabs);
    return this;
  }


  @Override
  public FluentTabs addThemeVariants(TabsVariant... variants)
  {
    get().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentTabs removeThemeVariants(TabsVariant... variants)
  {
    get().removeThemeVariants(variants);
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
