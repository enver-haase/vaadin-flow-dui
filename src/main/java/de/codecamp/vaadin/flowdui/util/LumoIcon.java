package de.codecamp.vaadin.flowdui.util;

import java.util.Locale;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.IconFactory;


/**
 * All <a href="https://vaadin.com/docs/latest/ds/foundation/icons">icons from the Lumo theme</a>.
 */
public enum LumoIcon
  implements
    IconFactory
{

  ALIGN_CENTER,
  ALIGN_LEFT,
  ALIGN_RIGHT,
  ANGLE_DOWN,
  ANGLE_LEFT,
  ANGLE_RIGHT,
  ANGLE_UP,
  ARROW_DOWN,
  ARROW_LEFT,
  ARROW_RIGHT,
  ARROW_UP,
  BAR_CHART,
  BELL,
  CALENDAR,
  CHECKMARK,
  CHEVRON_DOWN,
  CHEVRON_LEFT,
  CHEVRON_RIGHT,
  CHEVRON_UP,
  CLOCK,
  COG,
  CROSS,
  DOWNLOAD,
  DROPDOWN,
  EDIT,
  ERROR,
  EYE,
  EYE_DISABLED,
  MENU,
  MINUS,
  ORDERED_LIST,
  PHONE,
  PHOTO,
  PLAY,
  PLUS,
  REDO,
  RELOAD,
  SEARCH,
  UNDO,
  UNORDERED_LIST,
  UPLOAD,
  USER;


  /**
   * Returns new component instance of the icon.
   *
   * @return new component instance of the icon
   */
  @Override
  public Icon create()
  {
    return new Icon("lumo", name().toLowerCase(Locale.ENGLISH).replace('_', '-'));
  }

}
