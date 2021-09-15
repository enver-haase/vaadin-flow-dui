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


public class FluentButton
  extends FluentComponent<Button, FluentButton>
  implements
    FluentHasSize<Button, FluentButton>,
    FluentHasEnabled<Button, FluentButton>,
    FluentHasStyle<Button, FluentButton>,
    FluentClickNotifier<Button, FluentButton>,
    FluentHasText<Button, FluentButton>,
    FluentFocusable<Button, FluentButton>,
    FluentHasTheme<Button, FluentButton>
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


  public FluentButton themeVariants(ButtonVariant... variants)
  {
    getComponent().removeThemeVariants(ButtonVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentButton addThemeVariants(ButtonVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentButton removeThemeVariants(ButtonVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}
