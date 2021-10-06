package de.codecamp.vaadin.flowdui.components;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;

import de.codecamp.vaadin.flowdui.util.CssProperties;
import de.codecamp.vaadin.flowdui.util.LumoSpace;


@Tag("span")
public class Badge
  extends Component
  implements
    HasComponents,
    HasText,
    HasStyle,
    HasTheme
{

  public Badge()
  {
    getElement().getThemeList().add("badge");
  }

  public Badge(String text)
  {
    this();
    setText(text);
  }

  public Badge(Icon icon, String text)
  {
    this();
    prepareIcon(icon);
    add(icon, new Span(text));
  }

  public Badge(Component... components)
  {
    this();
    add(components);
  }


  /**
   * Adds theme variants to the component.
   *
   * @param variants
   *          theme variants to add
   */
  public void addThemeVariants(BadgeVariant... variants)
  {
    getThemeNames()
        .addAll(Stream.of(variants).map(BadgeVariant::getVariantName).collect(Collectors.toList()));
  }

  /**
   * Removes theme variants from the component.
   *
   * @param variants
   *          theme variants to remove
   */
  public void removeThemeVariants(BadgeVariant... variants)
  {
    getThemeNames().removeAll(
        Stream.of(variants).map(BadgeVariant::getVariantName).collect(Collectors.toList()));
  }


  /**
   * Prepares an {@link Icon} to fit nicely when adding it to a badge. The icon should not be
   * resized beforehand.
   *
   * @param icon
   *          the icon
   * @return the icon
   */
  public static Icon prepareIcon(Icon icon)
  {
    // also makes the icon smaller because padding is inside the fixed icon size
    icon.getElement().getStyle().set(CssProperties.padding, LumoSpace.XS.var());
    return icon;
  }

}
