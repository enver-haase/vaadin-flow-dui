package de.codecamp.vaadin.flowdui.fluent;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarGroup;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.component.upload.Upload;

import de.codecamp.vaadin.flowdui.components.Badge;
import de.codecamp.vaadin.flowdui.dialogs.MessageDialog;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentBigDecimalField;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentCheckbox;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentCheckboxGroup;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentComboBox;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentDatePicker;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentDateTimePicker;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentEmailField;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentIntegerField;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentListBox;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentMultiSelectListBox;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentNumberField;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentPasswordField;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentRadioButtonGroup;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentSelect;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentTextArea;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentTextField;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentTimePicker;
import de.codecamp.vaadin.flowdui.fluent.forminputs.FluentUpload;
import de.codecamp.vaadin.flowdui.fluent.layouts.FluentFlexLayout;
import de.codecamp.vaadin.flowdui.fluent.layouts.FluentHorizontalLayout;
import de.codecamp.vaadin.flowdui.fluent.layouts.FluentScroller;
import de.codecamp.vaadin.flowdui.fluent.layouts.FluentSplitLayout;
import de.codecamp.vaadin.flowdui.fluent.layouts.FluentVerticalLayout;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentAccordion;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentAvatar;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentAvatarGroup;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentBadge;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentButton;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentDetails;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentGrid;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentIcon;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentMenuBar;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentMessageDialog;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentNotification;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentProgressBar;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentTab;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentTabs;


public interface Fluent

{

  /*
   * Form Inputs
   */

  static FluentBigDecimalField bigDecimalField()
  {
    return new FluentBigDecimalField();
  }

  static FluentBigDecimalField fluent(BigDecimalField component)
  {
    return new FluentBigDecimalField(component);
  }

  static FluentCheckbox checkbox()
  {
    return new FluentCheckbox();
  }

  static FluentCheckbox fluent(Checkbox component)
  {
    return new FluentCheckbox(component);
  }

  static <ITEM> FluentCheckboxGroup<ITEM> checkboxGroup()
  {
    return new FluentCheckboxGroup<>();
  }

  static <ITEM> FluentCheckboxGroup<ITEM> fluent(CheckboxGroup<ITEM> component)
  {
    return new FluentCheckboxGroup<>(component);
  }

  static <ITEM> FluentComboBox<ITEM> comboBox()
  {
    return new FluentComboBox<>();
  }

  static <ITEM> FluentComboBox<ITEM> fluent(ComboBox<ITEM> component)
  {
    return new FluentComboBox<>(component);
  }

  static FluentDatePicker datePicker()
  {
    return new FluentDatePicker();
  }

  static FluentDatePicker fluent(DatePicker component)
  {
    return new FluentDatePicker(component);
  }

  static FluentDateTimePicker dateTimePicker()
  {
    return new FluentDateTimePicker();
  }

  static FluentDateTimePicker fluent(DateTimePicker component)
  {
    return new FluentDateTimePicker(component);
  }

  static FluentEmailField emailField()
  {
    return new FluentEmailField();
  }

  static FluentEmailField fluent(EmailField component)
  {
    return new FluentEmailField(component);
  }

  static FluentIntegerField integerField()
  {
    return new FluentIntegerField();
  }

  static FluentIntegerField fluent(IntegerField component)
  {
    return new FluentIntegerField(component);
  }

  static <ITEM> FluentListBox<ITEM> listBox()
  {
    return new FluentListBox<>();
  }

  static <ITEM> FluentListBox<ITEM> fluent(ListBox<ITEM> component)
  {
    return new FluentListBox<>(component);
  }

  static <ITEM> FluentMultiSelectListBox<ITEM> multiSelectListBox()
  {
    return new FluentMultiSelectListBox<>();
  }

  static <ITEM> FluentMultiSelectListBox<ITEM> fluent(MultiSelectListBox<ITEM> component)
  {
    return new FluentMultiSelectListBox<>(component);
  }

  static FluentNotification notification()
  {
    return new FluentNotification();
  }

  static FluentNotification fluent(Notification component)
  {
    return new FluentNotification(component);
  }

  static FluentNumberField numberField()
  {
    return new FluentNumberField();
  }

  static FluentNumberField fluent(NumberField component)
  {
    return new FluentNumberField(component);
  }

  static FluentPasswordField passwordField()
  {
    return new FluentPasswordField();
  }

  static FluentPasswordField fluent(PasswordField component)
  {
    return new FluentPasswordField(component);
  }

  static <ITEM> FluentRadioButtonGroup<ITEM> radioButtonGroup()
  {
    return new FluentRadioButtonGroup<>();
  }

  static <ITEM> FluentRadioButtonGroup<ITEM> fluent(RadioButtonGroup<ITEM> component)
  {
    return new FluentRadioButtonGroup<>(component);
  }

  static <ITEM> FluentSelect<ITEM> select()
  {
    return new FluentSelect<>();
  }

  static <ITEM> FluentSelect<ITEM> fluent(Select<ITEM> component)
  {
    return new FluentSelect<>(component);
  }

  static FluentTextArea textArea()
  {
    return new FluentTextArea();
  }

  static FluentTextArea fluent(TextArea component)
  {
    return new FluentTextArea(component);
  }

  static FluentTextField textField()
  {
    return new FluentTextField();
  }

  static FluentTextField fluent(TextField component)
  {
    return new FluentTextField(component);
  }

  static FluentTimePicker timePicker()
  {
    return new FluentTimePicker();
  }

  static FluentTimePicker fluent(TimePicker component)
  {
    return new FluentTimePicker(component);
  }

  static FluentUpload upload()
  {
    return new FluentUpload();
  }

  static FluentUpload fluent(Upload component)
  {
    return new FluentUpload(component);
  }



  /*
   * Visualization & Interaction
   */

  static FluentAccordion accordion()
  {
    return new FluentAccordion();
  }

  static FluentAccordion fluent(Accordion component)
  {
    return new FluentAccordion(component);
  }

  static FluentAvatar avatar()
  {
    return new FluentAvatar();
  }

  static FluentAvatar fluent(Avatar component)
  {
    return new FluentAvatar(component);
  }

  static FluentAvatarGroup avatarGroup()
  {
    return new FluentAvatarGroup();
  }

  static FluentAvatarGroup fluent(AvatarGroup component)
  {
    return new FluentAvatarGroup(component);
  }

  static FluentBadge badge()
  {
    return new FluentBadge();
  }

  static FluentBadge fluent(Badge component)
  {
    return new FluentBadge(component);
  }

  static FluentButton button()
  {
    return new FluentButton();
  }

  static FluentButton fluent(Button component)
  {
    return new FluentButton(component);
  }

  static FluentDetails details()
  {
    return new FluentDetails();
  }

  static FluentDetails fluent(Details component)
  {
    return new FluentDetails(component);
  }

  static <ITEM> FluentGrid<ITEM> grid()
  {
    return new FluentGrid<>();
  }

  static <ITEM> FluentGrid<ITEM> fluent(Grid<ITEM> component)
  {
    return new FluentGrid<>(component);
  }

  static FluentMenuBar menuBar()
  {
    return new FluentMenuBar();
  }

  static FluentMenuBar fluent(MenuBar component)
  {
    return new FluentMenuBar(component);
  }

  static FluentMessageDialog messageDialog()
  {
    return new FluentMessageDialog();
  }

  static FluentMessageDialog fluent(MessageDialog component)
  {
    return new FluentMessageDialog(component);
  }

  static FluentProgressBar progressBar()
  {
    return new FluentProgressBar();
  }

  static FluentProgressBar fluent(ProgressBar component)
  {
    return new FluentProgressBar(component);
  }

  static FluentTabs tabs()
  {
    return new FluentTabs();
  }

  static FluentTabs fluent(Tabs component)
  {
    return new FluentTabs(component);
  }

  static FluentTab tab()
  {
    return new FluentTab();
  }

  static FluentTab fluent(Tab component)
  {
    return new FluentTab(component);
  }

  static FluentScroller scroller()
  {
    return new FluentScroller();
  }

  static FluentScroller fluent(Scroller component)
  {
    return new FluentScroller(component);
  }



  static FluentIcon fluent(VaadinIcon component)
  {
    return new FluentIcon(component);
  }

  static FluentIcon fluent(Icon component)
  {
    return new FluentIcon(component);
  }



  /*
   * Layouts
   */

  static FluentHorizontalLayout horizontalLayout()
  {
    return new FluentHorizontalLayout();
  }

  static FluentHorizontalLayout fluent(HorizontalLayout component)
  {
    return new FluentHorizontalLayout(component);
  }

  static FluentVerticalLayout verticalLayout()
  {
    return new FluentVerticalLayout();
  }

  static FluentVerticalLayout fluent(VerticalLayout component)
  {
    return new FluentVerticalLayout(component);
  }

  static FluentFlexLayout flexLayout()
  {
    return new FluentFlexLayout();
  }

  static FluentFlexLayout fluent(FlexLayout component)
  {
    return new FluentFlexLayout(component);
  }

  static FluentSplitLayout splitLayout()
  {
    return new FluentSplitLayout();
  }

  static FluentSplitLayout fluent(SplitLayout component)
  {
    return new FluentSplitLayout(component);
  }

}
