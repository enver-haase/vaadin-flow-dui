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
    return get().getThemeNames();
  }

  default F applyToThemes(SerializableConsumer<ThemeList> configurator)
  {
    configurator.accept(getThemes());
    return (F) this;
  }


  default F themeName(String themeName, boolean set)
  {
    get().setThemeName(themeName, set);
    return (F) this;
  }

  default F themeNames(String... themeNames)
  {
    get().setThemeName("");
    get().addThemeNames(themeNames);
    return (F) this;
  }

  default F addThemeNames(String... themeNames)
  {
    get().addThemeNames(themeNames);
    return (F) this;
  }

  default F removeThemeNames(String... themeNames)
  {
    get().removeThemeNames(themeNames);
    return (F) this;
  }

}
