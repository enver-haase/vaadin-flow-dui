# Declarative UI for Vaadin Flow

This is basically Vaadin-8-style Declarative UI for Vaadin Flow. So unlike Polymer / LitElement templates, it's completely interpreted on the server-side. The goal is to support the same HTML like in a Polymer template (minus all the JavaScript), but offer additional attributes for convenience. See the [list of supports tags and attributes](#currently-supported-elements-and-attributes) further down.

# How does it work?

A component (or view) based on DUI consists of two parts: A Java class extending `TemplateComposite` and an HTML file beside it (same name, but .html extension). The HTML is parsed on the server-side. Components are created from HTML elements using `ComponentFactory` implementations. And `ComponentPostProcessor` implementations can be used to share mapping logic between all Components, e.g. for [mixin interfaces](https://vaadin.com/docs/v14/flow/creating-components/tutorial-component-mixins.html). The standard Vaadin components and the most important HTML elements work out of the box.

## Basic Example

A basic example for a DUI-based view that also demonstrates how components can be mapped from and into the template.

```java
// src/main/java/my/package/DuiView.java

@Route("dui-view")
public class DuiView
  extends TemplateComposite
{

  /**
   * Created in the template and mapped to this field.
   */
  @Mapped("shuffleButton")
  private Button button;

  /**
   * Created here and mapped into the template.
   */
  @Slotted("localeGrid")
  private Grid<Locale> localeGrid = new Grid<>(Locale.class);


  @Override
  protected Component initContent()
  {
    Component content = super.initContent();

    localeGrid.setColumns("displayLanguage", "displayCountry", "displayVariant");

    button.addClickListener(e -> shuffleLocales());

    return content;
  }

  private void shuffleLocales()
  {
    List<Locale> locales = Arrays.asList(Locale.getAvailableLocales());
    Collections.shuffle(locales);
    localeGrid.setItems(locales);
  }

}
```

```html
<!-- src/main/resources/my/package/DuiView.html -->

<vaadin-vertical-layout size-full>
  <slot name="localeGrid"></slot>
  <vaadin-button id="shuffleButton" theme="primary">Shuffle</vaadin-button>
</vaadin-vertical-layout>
```

## Adding Custom Elements and Attributes

Implementing new factories and post processors should for the most part be painless. Take a look at the source code to see plenty of examples.

In Spring Boot applications it should be enough to simply declare them as beans to have them automatically be picked up. In other environments use the following to add more factories and post processors:
```
TemplateBuilder.getAdditionalFactories().add(...)
TemplateBuilder.getAdditionalPostProcessors().add(...)
```


# Motivation

Basically, this add-on was created as a reaction to the [Vaadin Labs blog post about LitElement](https://vaadin.com/labs/lit-element) and resulting discussion in the comments.

The old Declarative UI (DUI) was a great way to externalize the layout of your application and have it as much more readable HTML/XML instead of as messy Java code. The interpretation of those layouts was completely on the server-side.
However, with Vaadin Flow (Vaadin 10+) DUI was dropped in favor of Polymer-based - or soon LitElement-based - templates. In contrast to DUI, these are primarily interpreted by the browser directly, but using `@Id` it was still possible to map a client-side element to a server-side Component. While this looks almost identical to the old Declarative UI, there is one major difference: The server-side Component does not know about the initial the client-side state from the template. And making changes to a component on the client-side might not always be reflected back to the server.
The resulting inconsistency between client- and server-side could easily lead to confusion, so going forward, it's currently Vaadin's intention to avoid this mixed approach, and instead focus on two very distinctive ones:

1. A server-owned UI built using the Java API. This is the old-school Vaadin way, only now without DUI. 

1. A client-owned UI built using Polymer/LitElement and TypeScript. Here, knowing the above mentioned issues, it makes sense that there's currently no plan to implement `@Id` for LitElement-based templates (which will replace Polymer in the long run). However, this leaves \<slot> as the only means to add server-owned Components to those client-side templates. This might be enough for leaf nodes in your layout, but accessing any element in between, like a split layout, on the server-side is no longer possible without workarounds.

While I do think the second approach is a great replacement for GWT to create new components, I'd like to stick mostly with Java to create my applications. This is basically where this add-on comes in: to give back the convenience of DUI with a predictable server-side state, while using basically the same HTML as in a Polymer template.

Anyway, see the mentioned [Vaadin Labs blog post about LitElement](https://vaadin.com/labs/lit-element) (and the discussion in the comments) for maybe some more details. And feel free to chime in if you have an opinion about this topic :)


# Currently Supported Elements and Attributes

This is an overview of the supported tags and attributes.

Tags or attributes prefixed with "! " (**not part of their actual name!**) aren't actual Web Components or part of their attributes; they're only added for convenience. So avoid them, if you want your HTML to stay compatible. If the tag is `*` it means, the attribute will work on all Components that extend or implement the given type.

| Tag | Component Type | Attribute | Description |
|-----------------------------------------------------|------------------------------|---------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
|  |  |  |  |
|  |  |  |  |
| slot | - | name | If you need to create a Component manually, you can add a slot tag, like for a Web Component, and annotate the field with your component with @Slotted("slotName"). The component will be inserted into the slot. |
| style | - |  | Copied verbatim. |
| custom-style | - |  | Copied verbatim. |
|  |  |  |  |
|  |  |  |  |
| * | Component |  |  |
|  |  | id |  |
|  |  | ! hidden | -> setVisible(..) |
| * | * | aria-label |  |
| * | * | aria-labelledby |  |
| * | * | aria-describedby |  |
| * | Focusable |  |  |
|  |  | tabindex |  |
| * | HasEnabled |  |  |
|  |  | disabled |  |
| * | HasSize |  |  |
|  |  | ! size-full |  |
|  |  | ! size-auto |  |
|  |  | ! width |  |
|  |  | ! width-full |  |
|  |  | ! width-auto |  |
|  |  | ! min-width |  |
|  |  | ! max-width |  |
|  |  | ! height |  |
|  |  | ! height-full |  |
|  |  | ! height-auto |  |
|  |  | ! min-height |  |
|  |  | ! max-height |  |
| * | HasStyle |  |  |
|  |  | class |  |
|  |  | style |  |
| * | HasTheme |  |  |
|  |  | theme |  |
| * | HasValidation |  |  |
|  |  | invalid |  |
|  |  | error-message |  |
| * | HasValue |  |  |
|  |  | required |  |
|  |  | readonly |  |
|  |  | value |  |
|  |  |  |  |
|  |  |  |  |
| vaadin-checkbox | [Checkbox](https://vaadin.com/components/vaadin-checkbox) |  |  |
|  |  | checked |  |
|  |  | indeterminate |  |
| vaadin-checkbox-group | CheckboxGroup |  | No children; use Java API. |
|  |  | label |  |
| vaadin-combo-box | [ComboBox](https://vaadin.com/components/vaadin-combo-box) |  | No children; use Java API. |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | clear-button-visible |  |
|  |  | allow-custom-value |  |
| vaadin-custom-field | [CustomField](https://vaadin.com/components/vaadin-custom-field) |  | Created this way, it's only a group of individual components with a shared label. Extending CustomField yourself is completely different. |
|  |  | label |  |
| vaadin-date-picker | [DatePicker](https://vaadin.com/components/vaadin-date-picker) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | show-week-numbers |  |
|  |  | clear-button-visible |  |
|  |  | initial-position |  |
| vaadin-list-box | [ListBox / MultiSelectListBox](https://vaadin.com/components/vaadin-list-box) |  | No children; use Java API. |
|  |  | multiple | Determines which class is used. |
| vaadin-radio-group | [RadioButtonGroup](https://vaadin.com/components/vaadin-radio-button) |  | No children; use Java API. |
|  |  | label |  |
| ~~vaadin-radio-button~~ |  |  | Can't be created directly. Use Java API of RadioButtonGroup. |
| vaadin-select | [Select](https://vaadin.com/components/vaadin-select) |  | No children; use Java API. |
|  |  | label |  |
|  |  | placeholder |  |
| vaadin-text-field | [TextField](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | minlength |  |
|  |  | maxlength |  |
|  |  | pattern |  |
|  |  | prevent-invalid-input |  |
|  |  | clear-button-visible |  |
| vaadin-text-area | [TextArea](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | minlength |  |
|  |  | maxlength |  |
|  |  | prevent-invalid-input |  |
|  |  | clear-button-visible |  |
| vaadin-password-field | [PasswordField](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | minlength |  |
|  |  | maxlength |  |
|  |  | pattern |  |
|  |  | prevent-invalid-input |  |
|  |  | clear-button-visible |  |
|  |  | reveal-button-hidden |  |
| vaadin-email-field | [EmailField](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | minlength |  |
|  |  | maxlength |  |
|  |  | pattern |  |
|  |  | prevent-invalid-input |  |
|  |  | clear-button-visible |  |
| vaadin-number-field | [NumberField](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | min |  |
|  |  | max |  |
|  |  | step |  |
|  |  | has-controls |  |
|  |  | clear-button-visible |  |
| vaadin-integer-field | [IntegerField](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | min |  |
|  |  | max |  |
|  |  | step |  |
|  |  | has-controls |  |
|  |  | clear-button-visible |  |
| vaadin-big-decimal-field | [BigDecimalField](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | clear-button-visible |  |
| * | HasPrefixAndSuffix |  | Slots: prefix, suffix |
| vaadin-time-picker | [TimePicker](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | min |  |
|  |  | max |  |
|  |  | step |  |
|  |  | clear-button-visible |  |
| vaadin-upload | [Upload](https://vaadin.com/components/vaadin-upload) |  | Slots: add-button, drop-label, drop-label-icon |
|  |  | nodrop |  |
|  |  | accept |  |
|  |  | max-files |  |
|  |  | max-file-size |  |
|  |  |  |  |
| vaadin-accordion | [Accordion](https://vaadin.com/components/vaadin-accordion) |  | Only vaadin-accordion-panel as child elements. |
|  |  | ! closed |  |
| vaadin-accordion-panel | AccordionPanel |  | Slots: summary |
| vaadin-button | [Button](https://vaadin.com/components/vaadin-button) |  |  |
|  |  | autofocus |  |
|  |  | disable-on-click | Slots: prefix, suffix (only one is supported; limit of the Java Component) |
| vaadin-details | [Details](https://vaadin.com/components/vaadin-details) |  | Slots: summary |
|  |  | opened |  |
| vaadin-dialog | [Dialog](https://vaadin.com/components/vaadin-dialog) |  |  |
|  |  | no-close-on-esc |  |
|  |  | no-close-on-outside-click |  |
| vaadin-grid | [Grid](https://vaadin.com/components/vaadin-grid) |  | No children; use Java API. |
| ! vaadin-tree-grid | [TreeGrid](https://vaadin.com/components/vaadin-grid) |  | No children; use Java API. |
| iron-icon | [Icon](https://vaadin.com/components/vaadin-icons) |  |  |
|  |  | icon |  |
|  |  | ! color |  |
|  |  | ! size |  |
| vaadin-menu-bar | [MenuBar](https://vaadin.com/components/vaadin-menu-bar) |  |  |
|  |  | open-on-hover |  |
| vaadin-progress-bar | [ProgressBar](https://vaadin.com/components/vaadin-progress-bar) |  |  |
|  |  | indeterminate |  |
|  |  | min |  |
|  |  | max |  |
|  |  | value |  |
| vaadin-tabs | [Tabs](https://vaadin.com/components/vaadin-tabs) |  | Only vaadin-tab as child elements. |
|  |  | orientation | orientation="vertical" |
|  |  | selected |  |
| vaadin-tab | Tab |  |  |
|  |  |  |  |
|  |  |  |  |
| fieldset |  |  | Styled to fit Lumo. |
| All the other HTML tags for which Vaadin provides Components. |  |  | There's some special attribute handling, all others are just copied verbatim. |
|  |  |  |  |
|  |  |  |  |
| vaadin-app-layout | [AppLayout](https://vaadin.com/components/vaadin-app-layout) |  | Slots: navbar (touch-optimized), drawer |
|  |  | primary-section |  | navbar, drawer
| vaadin-drawer-toggle | [DrawerToggle](https://vaadin.com/components/vaadin-app-layout) |  |  |
| vaadin-form-layout | [FormLayout](https://vaadin.com/components/vaadin-form-layout) |  |  |
|  |  | ! colspan | Attribute for child elements! |
| vaadin-form-item |  |  | Slots: label |
| vaadin-login-form | [LoginForm](https://vaadin.com/components/vaadin-login) |  |  |
| vaadin-login-overlay | [LoginOverlay](https://vaadin.com/components/vaadin-login) |  |  |
| vaadin-horizontal-layout | [HorizontalLayout](https://vaadin.com/components/vaadin-ordered-layout) |  | Default spacing of the Java component is removed per default. |
| vaadin-vertical-layout | [VerticalLayout](https://vaadin.com/components/vaadin-ordered-layout) |  | Default width, padding, spacing of the Java component is removed per default. |
| ! vaadin-flex-layout | FlexLayout |  | Not an official tag. Just a div with flex boy layout. [A Complete Guide to Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) |
|  |  | ! flex-wrap | -> setWrapMode(..) |
| * | ThemableLayout |  |  |
|  |  | ! margin |  |
|  |  | ! padding |  |
|  |  | ! spacing |  |
|  |  | ! box-sizing |  |
| * | FlexComponent |  | [A Complete Guide to Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) |
|  |  | ! align-items | Same as CSS property. |
|  |  | ! justify-content | Same as CSS property. |
|  |  | ! expand | Attribute for child elements! The same as flex-grow="1". |
|  |  | ! align-self | Attribute for child elements! Same as CSS property. |
|  |  | ! flex-grow | Attribute for child elements! Same as CSS property. |
| vaadin-split-layout | [SplitLayout](https://vaadin.com/components/vaadin-split-layout) |  |  |
|  |  | orientation | orientation="vertical" |
|  |  |  |  |
|  |  |  |  |
| vaadin-board | [Board](https://vaadin.com/components/vaadin-board) |  |  |
| vaadin-board-row | [Row](https://vaadin.com/components/vaadin-board) |  |  |
| vaadin-chart | [Chart](https://vaadin.com/components/vaadin-charts) |  |  |
| vaadin-cookie-consent | [CookieConsent](https://vaadin.com/components/vaadin-cookie-consent) |  |  |
|  |  | message |  |
|  |  | dismiss |  |
|  |  | learn-more |  |
|  |  | learn-more-link |  |
| vaadin-crud | [Crud](https://vaadin.com/components/vaadin-crud) |  |  |
| vaadin-grid-pro | [GridPro](https://vaadin.com/components/vaadin-grid-pro) |  |  |
| vaadin-rich-text-editor | [RichTextEditor](https://vaadin.com/components/vaadin-rich-text-editor) |  |  |
|  |  |  |  |
