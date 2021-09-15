package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.function.SerializableConsumer;


@SuppressWarnings("unchecked")
public interface FluentHasTheme<C extends HasTheme, F extends FluentHasTheme<C, F>>
  extends
    FluentHasElement<C, F>
{

  default ThemeList getThemes()
  {
    return getComponent().getThemeNames();
  }

  default F applyToThemes(SerializableConsumer<ThemeList> configurator)
  {
    configurator.accept(getThemes());
    return (F) this;
  }


  default F themeName(String themeName, boolean set)
  {
    getComponent().setThemeName(themeName, set);
    return (F) this;
  }

  default F themeNames(String... themeNames)
  {
    getComponent().setThemeName("");
    getComponent().addThemeNames(themeNames);
    return (F) this;
  }

  default F addThemeNames(String... themeNames)
  {
    getComponent().addThemeNames(themeNames);
    return (F) this;
  }

  default F removeThemeNames(String... themeNames)
  {
    getComponent().removeThemeNames(themeNames);
    return (F) this;
  }

}
