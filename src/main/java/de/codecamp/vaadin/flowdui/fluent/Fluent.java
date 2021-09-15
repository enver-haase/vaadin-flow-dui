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
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.menubar.MenuBar;
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
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentButton;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentDetails;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentGrid;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentIcon;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentIronIcon;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentMenuBar;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentProgressBar;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentTab;
import de.codecamp.vaadin.flowdui.fluent.visandint.FluentTabs;


public interface Fluent

{

  /*
   * Form Inputs
   */

  public static FluentBigDecimalField bigDecimalField()
  {
    return new FluentBigDecimalField();
  }

  public static FluentBigDecimalField fluent(BigDecimalField component)
  {
    return new FluentBigDecimalField(component);
  }

  public static FluentCheckbox checkbox()
  {
    return new FluentCheckbox();
  }

  public static FluentCheckbox fluent(Checkbox component)
  {
    return new FluentCheckbox(component);
  }

  public static <ITEM> FluentCheckboxGroup<ITEM> checkboxGroup()
  {
    return new FluentCheckboxGroup<>();
  }

  public static <ITEM> FluentCheckboxGroup<ITEM> fluent(CheckboxGroup<ITEM> component)
  {
    return new FluentCheckboxGroup<>(component);
  }

  public static <ITEM> FluentComboBox<ITEM> comboBox()
  {
    return new FluentComboBox<>();
  }

  public static <ITEM> FluentComboBox<ITEM> fluent(ComboBox<ITEM> component)
  {
    return new FluentComboBox<>(component);
  }

  public static FluentDatePicker datePicker()
  {
    return new FluentDatePicker();
  }

  public static FluentDatePicker fluent(DatePicker component)
  {
    return new FluentDatePicker(component);
  }

  public static FluentDateTimePicker dateTimePicker()
  {
    return new FluentDateTimePicker();
  }

  public static FluentDateTimePicker fluent(DateTimePicker component)
  {
    return new FluentDateTimePicker(component);
  }

  public static FluentEmailField emailField()
  {
    return new FluentEmailField();
  }

  public static FluentEmailField fluent(EmailField component)
  {
    return new FluentEmailField(component);
  }

  public static FluentIntegerField integerField()
  {
    return new FluentIntegerField();
  }

  public static FluentIntegerField fluent(IntegerField component)
  {
    return new FluentIntegerField(component);
  }

  public static <ITEM> FluentListBox<ITEM> listBox()
  {
    return new FluentListBox<>();
  }

  public static <ITEM> FluentListBox<ITEM> fluent(ListBox<ITEM> component)
  {
    return new FluentListBox<>(component);
  }

  public static <ITEM> FluentMultiSelectListBox<ITEM> multiSelectListBox()
  {
    return new FluentMultiSelectListBox<>();
  }

  public static <ITEM> FluentMultiSelectListBox<ITEM> fluent(MultiSelectListBox<ITEM> component)
  {
    return new FluentMultiSelectListBox<>(component);
  }

  public static FluentNumberField numberField()
  {
    return new FluentNumberField();
  }

  public static FluentNumberField fluent(NumberField component)
  {
    return new FluentNumberField(component);
  }

  public static FluentPasswordField passwordField()
  {
    return new FluentPasswordField();
  }

  public static FluentPasswordField fluent(PasswordField component)
  {
    return new FluentPasswordField(component);
  }

  public static <ITEM> FluentRadioButtonGroup<ITEM> radioButtonGroup()
  {
    return new FluentRadioButtonGroup<>();
  }

  public static <ITEM> FluentRadioButtonGroup<ITEM> fluent(RadioButtonGroup<ITEM> component)
  {
    return new FluentRadioButtonGroup<>(component);
  }

  public static <ITEM> FluentSelect<ITEM> select()
  {
    return new FluentSelect<>();
  }

  public static <ITEM> FluentSelect<ITEM> fluent(Select<ITEM> component)
  {
    return new FluentSelect<>(component);
  }

  public static FluentTextArea textArea()
  {
    return new FluentTextArea();
  }

  public static FluentTextArea fluent(TextArea component)
  {
    return new FluentTextArea(component);
  }

  public static FluentTextField textField()
  {
    return new FluentTextField();
  }

  public static FluentTextField fluent(TextField component)
  {
    return new FluentTextField(component);
  }

  public static FluentTimePicker timePicker()
  {
    return new FluentTimePicker();
  }

  public static FluentTimePicker fluent(TimePicker component)
  {
    return new FluentTimePicker(component);
  }

  public static FluentUpload upload()
  {
    return new FluentUpload();
  }

  public static FluentUpload fluent(Upload component)
  {
    return new FluentUpload(component);
  }



  /*
   * Visualization & Interaction
   */

  public static FluentAccordion accordion()
  {
    return new FluentAccordion();
  }

  public static FluentAccordion fluent(Accordion component)
  {
    return new FluentAccordion(component);
  }

  public static FluentAvatar avatar()
  {
    return new FluentAvatar();
  }

  public static FluentAvatar fluent(Avatar component)
  {
    return new FluentAvatar(component);
  }

  public static FluentAvatarGroup avatarGroup()
  {
    return new FluentAvatarGroup();
  }

  public static FluentAvatarGroup fluent(AvatarGroup component)
  {
    return new FluentAvatarGroup(component);
  }

  public static FluentButton button()
  {
    return new FluentButton();
  }

  public static FluentButton fluent(Button component)
  {
    return new FluentButton(component);
  }

  public static FluentDetails details()
  {
    return new FluentDetails();
  }

  public static FluentDetails fluent(Details component)
  {
    return new FluentDetails(component);
  }

  public static <ITEM> FluentGrid<ITEM> grid()
  {
    return new FluentGrid<>();
  }

  public static <ITEM> FluentGrid<ITEM> fluent(Grid<ITEM> component)
  {
    return new FluentGrid<>(component);
  }

  public static FluentMenuBar menuBar()
  {
    return new FluentMenuBar();
  }

  public static FluentMenuBar fluent(MenuBar component)
  {
    return new FluentMenuBar(component);
  }

  public static FluentProgressBar progressBar()
  {
    return new FluentProgressBar();
  }

  public static FluentProgressBar fluent(ProgressBar component)
  {
    return new FluentProgressBar(component);
  }

  public static FluentTabs tabs()
  {
    return new FluentTabs();
  }

  public static FluentTabs fluent(Tabs component)
  {
    return new FluentTabs(component);
  }

  public static FluentTab tab()
  {
    return new FluentTab();
  }

  public static FluentTab fluent(Tab component)
  {
    return new FluentTab(component);
  }

  public static FluentScroller scroller()
  {
    return new FluentScroller();
  }

  public static FluentScroller fluent(Scroller component)
  {
    return new FluentScroller(component);
  }



  public static FluentIcon fluent(VaadinIcon component)
  {
    return new FluentIcon(component);
  }

  public static FluentIcon fluent(Icon component)
  {
    return new FluentIcon(component);
  }

  public static FluentIronIcon fluent(IronIcon component)
  {
    return new FluentIronIcon(component);
  }



  /*
   * Layouts
   */

  public static FluentHorizontalLayout horizontalLayout()
  {
    return new FluentHorizontalLayout();
  }

  public static FluentHorizontalLayout fluent(HorizontalLayout component)
  {
    return new FluentHorizontalLayout(component);
  }

  public static FluentVerticalLayout verticalLayout()
  {
    return new FluentVerticalLayout();
  }

  public static FluentVerticalLayout fluent(VerticalLayout component)
  {
    return new FluentVerticalLayout(component);
  }

  public static FluentFlexLayout flexLayout()
  {
    return new FluentFlexLayout();
  }

  public static FluentFlexLayout fluent(FlexLayout component)
  {
    return new FluentFlexLayout(component);
  }

  public static FluentSplitLayout splitLayout()
  {
    return new FluentSplitLayout();
  }

  public static FluentSplitLayout fluent(SplitLayout component)
  {
    return new FluentSplitLayout(component);
  }

}
