package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentTab
  extends FluentComponent<Tab, FluentTab>
  implements
    FluentHasComponents<Tab, FluentTab>,
    FluentHasStyle<Tab, FluentTab>,
    FluentHasTheme<Tab, FluentTab>,
    FluentHasThemeVariants<Tab, FluentTab, TabVariant>
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
    get().setLabel(label);
    return this;
  }

  public FluentTab selected(boolean selected)
  {
    get().setSelected(selected);
    return this;
  }

  public FluentTab flexGrow(double flexGrow)
  {
    get().setFlexGrow(flexGrow);
    return this;
  }


  @Override
  public FluentTab addThemeVariants(TabVariant... variants)
  {
    get().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentTab removeThemeVariants(TabVariant... variants)
  {
    get().removeThemeVariants(variants);
    return this;
  }

  public FluentTab iconOnTop(boolean enabled)
  {
    return themeVariant(TabVariant.LUMO_ICON_ON_TOP, enabled);
  }

}
