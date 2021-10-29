package de.codecamp.vaadin.flowdui.dialogs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.dialog.DialogVariant;
import com.vaadin.flow.component.html.Aside;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.component.orderedlayout.Scroller;

import de.codecamp.vaadin.flowdui.util.CssProperties;
import de.codecamp.vaadin.flowdui.util.LumoBorderRadius;
import de.codecamp.vaadin.flowdui.util.LumoColor;
import de.codecamp.vaadin.flowdui.util.LumoSpace;


/**
 * This is a base class for dialogs that provides a basic commonly useful layout.
 * <ul>
 * <li>The <b>header area</b> is visually separated, but otherwise empty. Override
 * {@link #createHeader()} to customize.</li>
 * <li>The <b>footer area</b> is visually separated, but otherwise empty. Override
 * {@link #createFooter()} to customize.</li>
 * <li>The <b>sidebar area</b> is to the left of the content area. Override {@link #createSidebar()}
 * to customize.</li>
 * <li>The <b>content area</b> is {@link #getContentScroller() scrollable} if the content requires
 * more space than is available to the dialog. Before that, the dialog will grow to fit its content
 * as much as possible. Implement {@link #createContent()} to customize.</li>
 * </ul>
 */
public abstract class StructuredDialog
  extends Dialog
{

  private final Header header;

  private final Footer footer;

  private final Scroller contentScroller;

  private final Component content;

  private final Aside sidebar;


  protected StructuredDialog()
  {
    addThemeVariants(DialogVariant.LUMO_NO_PADDING);

    FlexLayout rootLayout = new FlexLayout();
    rootLayout.setFlexDirection(FlexDirection.COLUMN);

    /*
     * Default behavior for the dialog's root layout is to be as big as the content demands, but not
     * bigger than there is room. This ensures that the content scroller will scroll before the
     * whole dialog area.
     */
    rootLayout.setHeightFull();

    rootLayout.setAlignItems(Alignment.STRETCH);
    add(rootLayout);


    header = createHeader();
    if (header != null)
      rootLayout.add(header);


    FlexLayout contentSectionLayout = new FlexLayout();
    rootLayout.add(contentSectionLayout);
    // this line is important to prevent the whole dialog from scrolling
    contentSectionLayout.setMinHeight(LumoSpace.M.var());

    sidebar = createSidebar();
    if (sidebar != null)
      contentSectionLayout.add(sidebar);

    contentScroller = new Scroller();
    contentSectionLayout.add(contentScroller);
    contentSectionLayout.setFlexGrow(1, contentScroller);

    /*
     * Prevent content area from disappearing completely. If there's not enough height to allow even
     * this much space, the whole dialog will scroll, too.
     */
    contentScroller.setMinHeight(LumoSpace.M.var());

    content = createContent();
    contentScroller.setContent(content);


    footer = createFooter();
    if (footer != null)
      rootLayout.add(footer);
  }


  /**
   * Creates the header area of the dialog. Override to customize. May return null to completely
   * disable the header.
   *
   * @return the header or null
   */
  protected Header createHeader()
  {
    Header header = new Header();

    // round the top corners so a background can be set without leaving the dialog's border
    header.getStyle().set(CssProperties.borderTopLeftRadius, LumoBorderRadius.M.var());
    header.getStyle().set(CssProperties.borderTopRightRadius, LumoBorderRadius.M.var());

    header.getStyle().set(CssProperties.padding, LumoSpace.WideM.var());
    header.getStyle().set(CssProperties.borderBottom, "1px solid " + LumoColor.contrast10Pct.var());

    return header;
  }

  protected Header getHeader()
  {
    return header;
  }


  protected Scroller getContentScroller()
  {
    return contentScroller;
  }

  protected Aside createSidebar()
  {
    return new Aside();
  }

  protected Aside getSidebar()
  {
    return sidebar;
  }

  protected abstract Component createContent();

  protected Component getContent()
  {
    return content;
  }


  /**
   * Creates the footer area of the dialog. Override to customize. May return null to completely
   * disable the header.
   *
   * @return the footer or null
   */
  protected Footer createFooter()
  {
    Footer footer = new Footer();

    // round the bottom corners so a background can be set without leaving the dialog's border
    footer.getStyle().set(CssProperties.borderBottomLeftRadius, LumoBorderRadius.M.var());
    footer.getStyle().set(CssProperties.borderBottomRightRadius, LumoBorderRadius.M.var());
    footer.getStyle().set(CssProperties.backgroundColor, LumoColor.contrast5Pct.var());

    footer.getStyle().set(CssProperties.padding, LumoSpace.WideM.var());

    return footer;
  }

  protected Footer getFooter()
  {
    return footer;
  }

}
