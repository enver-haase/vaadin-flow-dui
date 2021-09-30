package de.codecamp.vaadin.flowdui.util;

import java.util.Arrays;

import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.dom.ThemeList;


/**
 * Themes related to spacing within a {@link ThemableLayout} that are not easily available otherwise
 * via the Java API.
 */
public enum ThemableLayoutSpacing
{

  XS("spacing-xs"),
  S("spacing-s"),
  M("spacing"),
  L("spacing-l"),
  XL("spacing-xl");


  private String theme;


  ThemableLayoutSpacing(String theme)
  {
    this.theme = theme;
  }


  public String theme()
  {
    return theme;
  }

  public void applyTo(ThemableLayout themableLayout)
  {
    ThemeList themeList = themableLayout.getThemeList();
    themeList.add(theme());
    Arrays.asList(ThemableLayoutSpacing.values()).forEach(s -> {
      if (s != this)
        themeList.remove(s.theme());
    });
  }

  public static void removeFrom(ThemableLayout themableLayout)
  {
    Arrays.asList(ThemableLayoutSpacing.values())
        .forEach(s -> themableLayout.getThemeList().remove(s.theme()));
  }

}
