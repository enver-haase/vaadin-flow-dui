package de.codecamp.vaadin.flowdui.dialogs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;

import de.codecamp.vaadin.flowdui.components.ButtonBar;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentButton;
import de.codecamp.vaadin.flowdui.util.CssProperties;
import de.codecamp.vaadin.flowdui.util.LumoColor;
import de.codecamp.vaadin.flowdui.util.LumoFontSize;
import de.codecamp.vaadin.flowdui.util.LumoSize;
import de.codecamp.vaadin.flowdui.util.LumoSpace;


/**
 * A dialog component providing a convenient base structure that is suitable for most message,
 * confirmation, question dialogs.
 */
public class MessageDialog
  extends StructuredDialog
{

  /**
   * The default max width of message dialogs.
   */
  public static final String DEFAULT_MAX_WIDTH = "40rem";


  private Icon icon;

  private Div title;

  private Div message;

  private ButtonBar buttonBar;

  private ColorTheme colorTheme = ColorTheme.STANDARD;


  /**
   * Creates a new empty message dialog.
   */
  public MessageDialog()
  {
    setMaxWidth(DEFAULT_MAX_WIDTH);

    setCloseOnEsc(false);
    setCloseOnOutsideClick(false);

    updateColors();
  }


  @Override
  protected Header createHeader()
  {
    Header header = super.createHeader();
    header.getStyle() //
        .remove(CssProperties.padding) //
        .set(CssProperties.height, LumoSpace.S.var());
    return header;
  }

  @Override
  protected Footer createFooter()
  {
    Footer footer = super.createFooter();

    buttonBar = new ButtonBar();
    footer.add(buttonBar);

    return footer;
  }

  @Override
  protected Component createContent()
  {
    Div content = new Div();
    content.getElement().getStyle() //
        .set(CssProperties.padding, LumoSpace.L.var() + " " + LumoSpace.XL.var());

    message = new Div();
    content.add(message);

    return content;
  }

  @Override
  protected Div getContent()
  {
    return (Div) super.getContent();
  }


  /**
   * Sets the icon of the message dialog.
   *
   * @param icon
   *          the new icon or null
   */
  public void setIcon(Icon icon)
  {
    getSidebar().removeAll();

    this.icon = icon;
    if (icon != null)
    {
      icon.getElement().getStyle() //
          .set(CssProperties.width, LumoSize.XL.var()) //
          .set(CssProperties.height, LumoSize.XL.var());

      Div iconFrame = new Div(icon);
      iconFrame.getElement().getStyle() //
          .set(CssProperties.margin, LumoSpace.L.var()) //
          .set(CssProperties.padding, LumoSpace.M.var());

      getContent().getElement().getStyle() //
          .set(CssProperties.paddingLeft, "0");

      iconFrame.getStyle() //
          .set(CssProperties.borderRadius, "50%");
      getSidebar().add(iconFrame);
      updateColors();
    }
    else
    {
      getContent().getElement().getStyle() //
          .remove(CssProperties.paddingLeft);
    }
  }

  /**
   * Sets the title of the message dialog.
   *
   * @param titleText
   *          the title
   */
  public void setTitle(String titleText)
  {
    if (titleText != null)
    {
      if (title != null)
      {
        title.setText(titleText);
      }
      else
      {
        title = new Div();
        title.setText(titleText);
        title.getStyle() //
            .set(CssProperties.fontSize, LumoFontSize.XL.var()) //
            .set(CssProperties.fontWeight, "bold") //
            .set(CssProperties.marginBottom, LumoSpace.M.var());
        getContent().addComponentAtIndex(0, title);
      }
    }
    else if (title != null)
    {
      getContent().remove(title);
      title = null;
    }
  }

  /**
   * Sets the message of the message dialog. Newlines will be handled appropriately to actually
   * create line breaks; HTML tags are escaped and not interpreted.
   *
   * @param messageText
   *          the message
   */
  public void setMessage(String messageText)
  {
    if (messageText == null)
    {
      setMessage();
      return;
    }

    Div messageDiv = new Div();
    boolean first = true;
    for (String token : messageText.split("\\r?\\n"))
    {
      if (first)
        first = false;
      else
        messageDiv.getElement().appendChild(ElementFactory.createBr());

      messageDiv.getElement().appendChild(Element.createText(token));
    }
    setMessage(messageDiv);
  }

  /**
   * Sets the message of the message dialog. HTML is actually intepreted as HTML and not escaped,
   * unlike with {@link #setMessage(String)}. <em>So be careful with user data.</em>
   *
   * @param messageText
   *          the message
   */
  public void setMessageAsHtml(String messageText)
  {
    if (messageText == null)
    {
      setMessage();
      return;
    }

    setMessage(new Html("<span>" + messageText + "</span>"));
  }

  /**
   * Sets the given components as message.
   *
   * @param messageComponents
   *          the message components
   */
  public void setMessage(Component... messageComponents)
  {
    message.removeAll();
    if (messageComponents != null && messageComponents.length > 0)
      message.add(messageComponents);
  }

  /**
   * Sets the color theme of the message dialog.
   *
   * @param colorTheme
   *          the color theme
   */
  public void setColorTheme(ColorTheme colorTheme)
  {
    this.colorTheme = colorTheme != null ? colorTheme : ColorTheme.STANDARD;
    updateColors();
  }


  private void updateColors()
  {
    switch (colorTheme)
    {
      case PRIMARY:
        getHeader().setVisible(true);
        getHeader().getStyle() //
            .set(CssProperties.backgroundColor, LumoColor.primaryColor.var());
        if (icon != null)
        {
          icon.getParent().get().getElement().getStyle() //
              .set(CssProperties.backgroundColor, LumoColor.primaryColor.var());
          icon.setColor(LumoColor.primaryContrastColor.var());
        }
        break;

      case SUCCESS:
        getHeader().setVisible(true);
        getHeader().getStyle() //
            .set(CssProperties.backgroundColor, LumoColor.successColor.var());
        if (icon != null)
        {
          icon.getParent().get().getElement().getStyle() //
              .set(CssProperties.backgroundColor, LumoColor.successColor.var());
          icon.setColor(LumoColor.successContrastColor.var());
        }
        break;

      case ERROR:
        getHeader().setVisible(true);
        getHeader().getStyle() //
            .set(CssProperties.backgroundColor, LumoColor.errorColor.var());
        if (icon != null)
        {
          icon.getParent().get().getElement().getStyle() //
              .set(CssProperties.backgroundColor, LumoColor.errorColor.var());
          icon.setColor(LumoColor.errorContrastColor.var());
        }
        break;

      case STANDARD:
      default:
        getHeader().setVisible(false);
        if (icon != null)
        {
          icon.getParent().get().getElement().getStyle() //
              .set(CssProperties.backgroundColor, LumoColor.contrast.var());
          icon.setColor(LumoColor.baseColor.var());
        }
        break;
    }
  }


  /**
   * Returns the button bar.
   *
   * @return the button bar
   */
  public ButtonBar getButtonBar()
  {
    return buttonBar;
  }

  /**
   * Adds a button to the primary button area to the right in the button bar.
   *
   * @return the new blank button
   */
  public FluentButton addButton()
  {
    return getButtonBar().addButtonToStart();
  }

  /**
   * Adds a button to the secondary button area to the left in the button bar.
   *
   * @return the new blank button
   */
  public FluentButton addButtonToSecondary()
  {
    return getButtonBar().addButtonToEnd();
  }


  /**
   * The available color themes of the {@link MessageDialog}.
   */
  public enum ColorTheme
  {
    STANDARD,
    PRIMARY,
    SUCCESS,
    ERROR
  }

}
