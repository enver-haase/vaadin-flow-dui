# Declarative UI for Vaadin Flow

This is basically Vaadin-8-style Declarative UI for Vaadin Flow. The goal is to externalize the layout of the components in your application and have it as much more readable HTML/XML instead of cluttering up your Java code. It's completely interpreted and converted to a Component-tree on the server-side.

# Why use this over Polymer / LitElement templates?

I created this addon, because of two major issues:

 * The initial state of components in Polymer / LitElement templates is not available on the server-side. Although, there are now [plans to support this in Vaadin 18](https://vaadin.com/blog/future-of-html-templates-in-vaadin).
 * Vaadin did not intend to support [@Id to map components from a LitElement template](https://vaadin.com/labs/lit-element) to a field in Java. But in the meantime they [changed their stance on this](https://vaadin.com/blog/future-of-html-templates-in-vaadin), too:

So now that my most important concerns are being or will be addressed, it remains to be seen how useful this addon will be in the future. But currently it still offers a few advantages for the purely Java-based approach of Vaadin Flow that could very well be worth it.
 * While the HTML-like syntax of DUI is mostly compatible with the syntax from Polymer / LitElement templates, it adds a few conveniences e.g. regarding sizing and layouting. See the [list of supports tags and attributes](#currently-supported-elements-and-attributes) further down.
 * It's extensible. Add your own custom elements and attributes!
 * Definitely no inconsistencies between client- and server-side state as everything is done through the server-side Java API.

To be fair, there's also a potential disadvantage to keep in mind: The memory overhead on the server-side is bigger compared to Polymer / LitElement as every element in the template will have a corresponding Component, not just the ones you need to access in Java. But in principle I'd expect the overhead to be similar to Vaadin 8's Declarative UI.


# How does it work?

A component or view based on DUI consists of two parts:
 * a Java class extending `TemplateComposite`
 * an HTML file containing the component tree
Per default, the HTML file is expected beside the Java class (same name, but .html extension) in the classpath. The HTML is parsed on the server-side. Components are created from HTML elements using `ComponentFactory` implementations. And `ComponentPostProcessor` implementations can be used to share mapping logic between all Components, e.g. for [mixin interfaces](https://vaadin.com/docs/v14/flow/creating-components/tutorial-component-mixins.html). The standard Vaadin components and the most important HTML elements work out of the box. But it's easy to add your own elements.

## Basic Example

A basic example for a DUI-based view that also demonstrates how components can be mapped from and into the template.

```java
// src/main/java/my/package/DemoView.java

@Route("demo")
public class DemoView
  extends TemplateComposite
{

  /**
   * Created in the template and mapped to this field.
   */
  @Mapped("shuffleButton")
  private Button shuffleButton;

  /**
   * Created here and mapped into the template.
   */
  @Slotted("localeGrid")
  private Grid<Locale> localeGrid = new Grid<>(Locale.class);


  public DemoView()
  {
  }


  @Override
  protected Component initContent()
  {
    Component content = super.initContent();

    localeGrid.removeAllColumns();
    localeGrid.addColumn(Locale::toLanguageTag).setHeader("Language Tag");
    localeGrid.addColumn("displayLanguage");
    localeGrid.addColumn("displayCountry");
    localeGrid.addColumn("displayVariant");
    localeGrid.setDetailsVisibleOnClick(true);
    localeGrid.setItemDetailsRenderer(new ComponentRenderer<>(locale -> {
      LocaleDetails details = new LocaleDetails();
      details.setLocale(locale);
      return details;
    }));


    shuffleButton.addClickListener(e -> shuffleLocales());

    localeGrid.setItems(Locale.getAvailableLocales());

    return content;
  }

  private void shuffleLocales()
  {
    List<Locale> locales = Arrays.asList(Locale.getAvailableLocales());
    Collections.shuffle(locales);
    localeGrid.setItems(locales);
  }


  @FragmentId("DetailsFragment")
  public static class LocaleDetails
    extends FragmentComposite
  {

    @Mapped("info")
    private TextField info;


    public void setLocale(Locale locale)
    {
      info.setValue(locale.getDisplayLanguage(locale) + " / " + locale.getDisplayCountry(locale)
          + " / " + locale.getDisplayVariant(locale));
    }

  }

}
```

```html
<!-- src/main/resources/my/package/DemoView.html -->

<vaadin-vertical-layout size-full>
  <slot name="localeGrid"></slot>
  <vaadin-button id="shuffleButton" theme="primary">Shuffle</vaadin-button>
</vaadin-vertical-layout>

<fragment id="DetailsFragment">
  <vaadin-horizontal-layout width-full>
    <vaadin-text-field id="info" readonly width-full>
    </vaadin-text-field>
  </vaadin-horizontal-layout>
</fragment>
```

## Adding Custom Elements and Attributes

Implementing new factories (`ComponentFactory`) and post processors (`ComponentPostProcessor`) should for the most part be painless. Take a look at the source code to see plenty of examples.

In Spring Boot applications it's enough to simply declare them as beans to have them automatically be picked up. In other environments they can be registered manually:
```
TemplateEngine.getAdditionalFactories().add(...)
TemplateEngine.getAdditionalPostProcessors().add(...)
```

## Load Templates From Other Sources

Per default, the HTML file is expected besides the Java class in the classpath.

There's also support to load them from JavaScript-based Polymer / LitElement templates. This might allow you to still make use of Vaadin Designer, but this isn't thoroughly tested and would probably require you to avoid any of the custom attributes and components.

Besides from the classpath, the template document can also be loaded from any other source by providing additional `TemplateResolver` implementations. 
In Spring Boot applications they'll be automatically picked up as beans. In other environments they can be registered manually:

```
TemplateEngine.getAdditionalResolvers().add(...)
```


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
| template | - | id | Analogous to [HTML's \<template>](https://developer.mozilla.org/en-US/docs/Web/Web_Components/Using_templates_and_slots). Define a UI fragment that is not rendered immediately, but can be created programmatically whenever and however often you need it. See the example above on how to use them. |
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
| * | HasHelper |  |  |
|  |  | helper-text |  |
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
|  |  | min |  |
|  |  | max |  |
|  |  | step |  |
|  |  | clear-button-visible |  |
|  |  | initial-position |  |
| vaadin-date-time-picker | [DateTimePicker](https://vaadin.com/components/vaadin-date-time-picker) |  |  |
|  |  | label |  |
|  |  | date-placeholder |  |
|  |  | time-placeholder |  |
|  |  | show-week-numbers |  |
|  |  | min |  |
|  |  | max |  |
|  |  | step |  |
|  |  | clear-button-visible |  |
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
|  |  | capture |  |
|  |  |  |  |
| vaadin-accordion | [Accordion](https://vaadin.com/components/vaadin-accordion) |  | Only vaadin-accordion-panel as child elements. |
|  |  | ! closed |  |
| vaadin-accordion-panel | AccordionPanel |  | Slots: summary |
| vaadin-avatar | [Avatar](https://vaadin.com/docs/latest/ds/components/avatar) |  |  |
|  |  | name |  |
|  |  | abbr |  |
|  |  | img |  |
|  |  | color-index |  |
| vaadin-avatar-group | [Avatar](https://vaadin.com/docs/latest/ds/components/avatar) |  |  |
|  |  | max-items-visible |  |
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
| * | ThemableLayout |  |  |
|  |  | ! margin | active when attribute present; attribute has no value |
|  |  | ! padding | active when attribute present; attribute has no value |
|  |  | ! spacing | active when attribute present; also supports **xs**, **s**, **m** (default), **l**, **xl** |
|  |  | ! box-sizing | border-box, content-box |
| vaadin-scroller | [Scroller](https://vaadin.com/components/vaadin-ordered-layout) |  |  |
|  |  | scroll-direction |  | both (default), horizontal, vertical, none
| ! vaadin-flex-layout | FlexLayout |  | Doesn't exist as WebComponent. Just a div with flex box layout. [A Complete Guide to Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/). Also see attributes of FlexComponent. |
|  |  | align-content | -> setAlignContent(..) |
|  |  | flex-direction | -> setFlexDirection(..) |
|  |  | flex-wrap | -> setWrapMode(..) |
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
