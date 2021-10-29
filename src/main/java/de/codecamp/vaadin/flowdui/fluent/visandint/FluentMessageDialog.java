package de.codecamp.vaadin.flowdui.fluent.visandint;

import static java.util.Objects.requireNonNull;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.dialog.Dialog.DialogCloseActionEvent;
import com.vaadin.flow.component.dialog.GeneratedVaadinDialog.OpenedChangeEvent;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.function.SerializableSupplier;

import de.codecamp.vaadin.flowdui.dialogs.MessageDialog;
import de.codecamp.vaadin.flowdui.dialogs.MessageDialog.ColorTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;


public class FluentMessageDialog
  implements
    FluentHasSize<MessageDialog, FluentMessageDialog>,
    SerializableSupplier<MessageDialog>
{

  private final MessageDialog dialog;


  public FluentMessageDialog()
  {
    this(new MessageDialog());
  }

  public FluentMessageDialog(MessageDialog dialog)
  {
    this.dialog = requireNonNull(dialog, "dialog must not be null");
  }


  @Override
  public MessageDialog get()
  {
    return dialog;
  }


  public FluentMessageDialog icon(Icon icon)
  {
    get().setIcon(icon);
    return this;
  }

  public FluentMessageDialog title(String title)
  {
    get().setTitle(title);
    return this;
  }

  public FluentMessageDialog message(String message)
  {
    get().setMessage(message);
    return this;
  }

  public FluentMessageDialog messageAsHtml(String message)
  {
    get().setMessageAsHtml(message);
    return this;
  }

  public FluentMessageDialog closeOnEsc(boolean closeOnEsc)
  {
    get().setCloseOnEsc(closeOnEsc);
    return this;
  }

  public FluentMessageDialog closeOnOutsideClick(boolean closeOnOutsideClick)
  {
    get().setCloseOnOutsideClick(closeOnOutsideClick);
    return this;
  }

  public FluentMessageDialog standard()
  {
    get().setColorTheme(ColorTheme.STANDARD);
    return this;
  }

  public FluentMessageDialog primary()
  {
    get().setColorTheme(ColorTheme.PRIMARY);
    return this;
  }

  public FluentMessageDialog success()
  {
    get().setColorTheme(ColorTheme.SUCCESS);
    return this;
  }

  public FluentMessageDialog error()
  {
    get().setColorTheme(ColorTheme.ERROR);
    return this;
  }


  public FluentButton button()
  {
    return get().addButton();
  }

  public FluentMessageDialog button(
      SerializableBiConsumer<FluentMessageDialog, FluentButton> buttonConfigurator)
  {
    buttonConfigurator.accept(this, get().addButton());
    return this;
  }

  public FluentButton buttonToSecondary()
  {
    return get().addButtonToSecondary();
  }

  public FluentMessageDialog buttonToSecondary(
      SerializableBiConsumer<FluentMessageDialog, FluentButton> buttonConfigurator)
  {
    buttonConfigurator.accept(this, get().addButtonToSecondary());
    return this;
  }


  public FluentMessageDialog onOpenedChange(
      ComponentEventListener<OpenedChangeEvent<Dialog>> listener)
  {
    get().addOpenedChangeListener(listener);
    return this;
  }

  public FluentMessageDialog onDialogCloseAction(
      ComponentEventListener<DialogCloseActionEvent> listener)
  {
    get().addDialogCloseActionListener(listener);
    return this;
  }


  public FluentMessageDialog open()
  {
    get().open();
    return this;
  }

  public FluentMessageDialog close()
  {
    get().close();
    return this;
  }

}
