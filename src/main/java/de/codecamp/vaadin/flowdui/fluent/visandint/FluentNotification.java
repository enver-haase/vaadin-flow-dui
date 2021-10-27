package de.codecamp.vaadin.flowdui.fluent.visandint;

import java.time.Duration;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.GeneratedVaadinNotification.OpenedChangeEvent;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasComponents;
import de.codecamp.vaadin.flowdui.fluent.FluentHasEnabled;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentNotification
  extends FluentComponent<Notification, FluentNotification>
  implements
    FluentHasEnabled<Notification, FluentNotification>,
    FluentHasComponents<Notification, FluentNotification>,
    FluentHasTheme<Notification, FluentNotification>,
    FluentHasThemeVariants<Notification, FluentNotification, NotificationVariant>
{

  /**
   * The default duration. Should be the same as defined in a private constant in
   * {@link Notification}.
   */
  private static final int DEFAULT_DURATION = 5000;


  public FluentNotification()
  {
    this(new Notification());
    get().setDuration(DEFAULT_DURATION);
  }

  public FluentNotification(Notification component)
  {
    super(component);
  }


  public FluentNotification text(String text)
  {
    get().setText(text);
    return this;
  }

  public FluentNotification duration(int duration)
  {
    get().setDuration(duration);
    return this;
  }

  public FluentNotification duration(Duration duration)
  {
    if (duration == null)
      get().setDuration(0);
    else
      get().setDuration(Math.toIntExact(duration.toMillis()));
    return this;
  }

  public FluentNotification durationIndefinite()
  {
    return duration(null);
  }


  public FluentNotification opened(boolean opened)
  {
    get().setOpened(opened);
    return this;
  }

  public FluentNotification open()
  {
    get().open();
    return this;
  }

  public FluentNotification close()
  {
    get().close();
    return this;
  }

  public FluentNotification onOpenedChange(
      ComponentEventListener<OpenedChangeEvent<Notification>> listener)
  {
    get().addOpenedChangeListener(listener);
    return this;
  }


  public FluentNotification position(Position position)
  {
    get().setPosition(position);
    return this;
  }

  public FluentNotification positionTopStretch()
  {
    get().setPosition(Position.TOP_STRETCH);
    return this;
  }

  public FluentNotification positionTopStart()
  {
    get().setPosition(Position.TOP_START);
    return this;
  }

  public FluentNotification positionTopCenter()
  {
    get().setPosition(Position.TOP_CENTER);
    return this;
  }

  public FluentNotification positionTopEnd()
  {
    get().setPosition(Position.TOP_END);
    return this;
  }

  public FluentNotification positionTopMiddle()
  {
    get().setPosition(Position.MIDDLE);
    return this;
  }

  public FluentNotification positionBottomStart()
  {
    get().setPosition(Position.BOTTOM_START);
    return this;
  }

  public FluentNotification positionBottomCenter()
  {
    get().setPosition(Position.BOTTOM_CENTER);
    return this;
  }

  public FluentNotification positionBottomEnd()
  {
    get().setPosition(Position.BOTTOM_END);
    return this;
  }

  public FluentNotification positionBottomStretch()
  {
    get().setPosition(Position.BOTTOM_STRETCH);
    return this;
  }


  @Override
  public FluentNotification addThemeVariants(NotificationVariant... variants)
  {
    get().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentNotification removeThemeVariants(NotificationVariant... variants)
  {
    get().removeThemeVariants(variants);
    return this;
  }


  public FluentNotification primary()
  {
    return addThemeVariants(NotificationVariant.LUMO_PRIMARY);
  }

  public FluentNotification secondary()
  {
    return removeThemeVariants(NotificationVariant.LUMO_PRIMARY);
  }


  public FluentNotification standard()
  {
    return removeThemeVariants(NotificationVariant.LUMO_SUCCESS, NotificationVariant.LUMO_ERROR,
        NotificationVariant.LUMO_CONTRAST);
  }

  public FluentNotification success()
  {
    removeThemeVariants(NotificationVariant.LUMO_ERROR, NotificationVariant.LUMO_CONTRAST);
    return addThemeVariants(NotificationVariant.LUMO_SUCCESS);
  }

  public FluentNotification error()
  {
    removeThemeVariants(NotificationVariant.LUMO_SUCCESS, NotificationVariant.LUMO_CONTRAST);
    return addThemeVariants(NotificationVariant.LUMO_ERROR);
  }

  public FluentNotification contrast()
  {
    removeThemeVariants(NotificationVariant.LUMO_SUCCESS, NotificationVariant.LUMO_ERROR);
    return addThemeVariants(NotificationVariant.LUMO_CONTRAST);
  }

}
