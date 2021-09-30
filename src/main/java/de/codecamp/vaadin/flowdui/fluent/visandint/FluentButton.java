package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentClickNotifier;
import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasEnabled;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasText;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentButton
  extends FluentComponent<Button, FluentButton>
  implements
    FluentHasSize<Button, FluentButton>,
    FluentHasEnabled<Button, FluentButton>,
    FluentHasStyle<Button, FluentButton>,
    FluentClickNotifier<Button, FluentButton>,
    FluentHasText<Button, FluentButton>,
    FluentFocusable<Button, FluentButton>,
    FluentHasTheme<Button, FluentButton>,
    FluentHasThemeVariants<Button, FluentButton, ButtonVariant>
{

  public FluentButton()
  {
    this(new Button());
  }

  public FluentButton(Button component)
  {
    super(component);
  }


  public FluentButton icon(Component icon)
  {
    getComponent().setIcon(icon);
    return this;
  }

  public FluentButton iconAfterText(boolean iconAfterText)
  {
    getComponent().setIconAfterText(iconAfterText);
    return this;
  }

  public FluentButton click()
  {
    getComponent().click();
    return this;
  }

  public FluentButton clickInClient()
  {
    getComponent().clickInClient();
    return this;
  }

  public FluentButton autofocus(boolean autofocus)
  {
    getComponent().setAutofocus(autofocus);
    return this;
  }

  public FluentButton disableOnClick(boolean disableOnClick)
  {
    getComponent().setDisableOnClick(disableOnClick);
    return this;
  }


  @Override
  public FluentButton addThemeVariants(ButtonVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentButton removeThemeVariants(ButtonVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

  public FluentButton iconOnly(boolean enabled)
  {
    return themeVariant(ButtonVariant.LUMO_ICON, enabled);
  }


  public FluentButton small()
  {
    removeThemeVariants(ButtonVariant.LUMO_LARGE);
    return addThemeVariants(ButtonVariant.LUMO_SMALL);
  }

  public FluentButton medium()
  {
    return removeThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_LARGE);
  }

  public FluentButton large()
  {
    removeThemeVariants(ButtonVariant.LUMO_SMALL);
    return addThemeVariants(ButtonVariant.LUMO_LARGE);
  }


  public FluentButton primary()
  {
    removeThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_TERTIARY_INLINE);
    return addThemeVariants(ButtonVariant.LUMO_PRIMARY);
  }

  public FluentButton secondary()
  {
    return removeThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_TERTIARY,
        ButtonVariant.LUMO_TERTIARY_INLINE);
  }

  public FluentButton tertiary()
  {
    removeThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_TERTIARY_INLINE);
    return addThemeVariants(ButtonVariant.LUMO_TERTIARY);
  }

  public FluentButton tertiaryInline()
  {
    removeThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_TERTIARY);
    return addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
  }


  public FluentButton standard()
  {
    return removeThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_ERROR,
        ButtonVariant.LUMO_CONTRAST);
  }

  public FluentButton success()
  {
    removeThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_CONTRAST);
    return addThemeVariants(ButtonVariant.LUMO_SUCCESS);
  }

  public FluentButton error()
  {
    removeThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_CONTRAST);
    return addThemeVariants(ButtonVariant.LUMO_ERROR);
  }

  public FluentButton contrast()
  {
    removeThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_ERROR);
    return addThemeVariants(ButtonVariant.LUMO_CONTRAST);
  }

}
