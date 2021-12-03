
# Declarative UI (DUI) for Vaadin Flow

This is basically Vaadin-8-style Declarative UI for Vaadin Flow. The goal is to externalize the layout of views (or parts of views) in an application and have it as much more readable HTML/XML instead of cluttering up the Java code. For some added convenience there's also an experimental fluent-style API for most Vaadin components.  

## DUI vs Lit

There is some overlap with [Lit-based templates](https://vaadin.com/docs/latest/flow/templates/overview), but the goals and approach are different.

 * DUI has none of the [limitations Lit templates have](https://vaadin.com/docs/latest/flow/templates/mapped-components-limitations). It's completely interpreted and converted to a Component-tree on the server-side. So one can expect exactly the same behavior as using the Java API directly.
* DUI likely has a bigger memory overhead on the server-side, because every element is represented there, whether you need to actually access it or not. But if the overhead of Vaadin 8's DUI wasn't a concern, it shouldn't be one here either.
 * DUI does not support JavaScript or CSS, and is not ideal when you intend to also use actual HTML elements. The focus is purely on the composition of components. Lit is likely the better option when creating new or heavily customized components.
 * While the HTML-like syntax of DUI for each component is mostly compatible with their respective Web Component API (as it is also used in Lit templates), it adds a few conveniences that you might already know from Vaadin 8 but which aren't available in Lit templates. E.g. adding `size-full` is more convenient that using the equivalent CSS. See the [list of supports tags and attributes](#currently-supported-elements-and-attributes) further down.
 * DUI is extensible. Add your own custom elements and attributes (even to existing components)!


# How does it work?

A component or view based on DUI consists of two parts:
 * an HTML-like template file containing the component tree
 * a Java class receiving components mapped from the template, usually sextending `TemplateComposite`
Per default, the HTML file is expected beside the Java class (same name, but .html extension) in the classpath. The HTML is parsed on the server-side. Components are created from HTML elements using `ComponentFactory` implementations. And `ComponentPostProcessor` implementations are used to apply mapping and other logic to multiple Component types, e.g. for [mixin interfaces](https://vaadin.com/docs/latest/flow/creating-components/mixins). The standard Vaadin components work out of the box, but it's easy to add your own elements.

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

## Fluent-Style API

For an additional bit of convenience, there's also an experimental fluent-style API as a complementary way to configure components. It's not suited or intended to compose hierarchical layouts; not more than the regular Java API anyway. Here's a few hints on how the fluent API is designed in general:
- For most Vaadin components (and mix-in interfaces) there is an equivalent wrapper class prefixed with `Fluent`. So e.g. there's a `FluentButton` for `Button`.
- The wrapped `Component` can be accessed directly using `get()`. For short-term access the following can be convenient:

```
fluentComponent.apply(c -> {
})`.
```
- For setters the `set` has been omitted from the fluent equivalent. E.g.: `setId(...)` -> `id(...)`.
- For event listener registration methods the `add` has been replaced with `on` and `Listener` has been omitted. E.g.: `addClickListener(...)` -> `onClick(...)`. If you need the `Registration` you need to access the `Component` and register the listener there the regular way.
- The Lumo-related theme variants are a simple method call in the fluent API. E.g.: `ButtonVariant#LUMO_PRIMARY` -> `primary()`. Where the variants are mutually exclusive the other variants are transparently removed. Some gaps in the variants have been filled. E.g. for buttons there's `LUMO_PRIMARY`, `LUMO_TERTIARY` and `LUMO_TERTIARY_INLINE`, but no `LUMO_SECONDARY` because it's the default and defined by the absence of all others. `secondary()` takes care of that.
- The static methods of `de.codecamp.vaadin.flowdui.fluent.Fluent` serve as a manual entry point to creating new or wrapping existing components in a fluent wrapper.

```java
import static de.codecamp.vaadin.flowdui.fluent.Fluent.*;

...

FluentButton button1 = button().text("Label").primary().onClick(event -> {
  Notification.show("Clicked.")
});

fluent(someButton).text("Label").primary();
```

But components from the template can also be automatically wrapped in the fluent API simply when mapping them to a field via `@Mapped` by using the fluent type instead of the regular component type.

```java
@Route("fluent-demo")
public class FluentDemoView
  extends TemplateComposite
{

  @Mapped
  private FluentButton button;


  @Override
  protected Component initContent()
  {
    Component content = super.initContent();

    button.text("Label").primary().onClick(event -> {
      Notification.show("Clicked.");
    });

    return content;
  }

}
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

There's also support to load them from JavaScript-based Lit templates. This might allow you to still make use of Vaadin Designer, but this isn't thoroughly tested and would probably require you to avoid any of the custom attributes and components.

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
| fragment | - | id | Defines a UI fragment that is not rendered immediately, but can be created programmatically whenever and however often you need it. See the example above on how to use fragments. |
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
| vaadin-checkbox | [Checkbox](https://vaadin.com/docs/latest/ds/components/checkbox) |  |  |
|  |  | checked |  |
|  |  | indeterminate |  |
| vaadin-checkbox-group | [CheckboxGroup](https://vaadin.com/docs/latest/ds/components/checkbox) |  | No children; use Java API. |
|  |  | label |  |
| vaadin-combo-box | [ComboBox](https://vaadin.com/docs/latest/ds/components/combo-box) |  | No children; use Java API. |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | clear-button-visible |  |
|  |  | allow-custom-value |  |
| vaadin-date-picker | [DatePicker](https://vaadin.com/docs/latest/ds/components/date-picker) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | show-week-numbers |  |
|  |  | min | ISO-8601 formatted local date, e.g. 2007-12-03 |
|  |  | max | ISO-8601 formatted local date, e.g. 2007-12-03 |
|  |  | locale | IETF BCP 47 language tag, e.g. en-US |
|  |  | step |  |
|  |  | clear-button-visible |  |
|  |  | initial-position |  |
| vaadin-date-time-picker | [DateTimePicker](https://vaadin.com/docs/latest/ds/components/date-time-picker) |  |  |
|  |  | label |  |
|  |  | date-placeholder |  |
|  |  | time-placeholder |  |
|  |  | show-week-numbers |  |
|  |  | min | ISO-8601 formatted local date-time, e.g. 2007-12-03T10:15:30 |
|  |  | max | ISO-8601 formatted local date-time, e.g. 2007-12-03T10:15:30 |
|  |  | locale | IETF BCP 47 language tag, e.g. en-US |
|  |  | step |  |
|  |  | clear-button-visible |  |
| vaadin-list-box | [ListBox / MultiSelectListBox](https://vaadin.com/docs/latest/ds/components/list-box) |  | No children; use Java API. |
|  |  | multiple | Determines which class is used. |
| vaadin-radio-group | [RadioButtonGroup](https://vaadin.com/docs/latest/ds/components/radio-button) |  | No children; use Java API. |
|  |  | label |  |
| ~~vaadin-radio-button~~ |  |  | Can't be created directly. Use Java API of RadioButtonGroup. |
| vaadin-select | [Select](https://vaadin.com/docs/latest/ds/components/select) |  | No children; use Java API. |
|  |  | label |  |
|  |  | placeholder |  |
| vaadin-text-field | [TextField](https://vaadin.com/docs/latest/ds/components/text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | minlength |  |
|  |  | maxlength |  |
|  |  | pattern |  |
|  |  | prevent-invalid-input |  |
|  |  | clear-button-visible |  |
| vaadin-text-area | [TextArea](https://vaadin.com/docs/latest/ds/components/text-area) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | minlength |  |
|  |  | maxlength |  |
|  |  | prevent-invalid-input |  |
|  |  | clear-button-visible |  |
| vaadin-password-field | [PasswordField](https://vaadin.com/docs/latest/ds/components/password-field) |  |  |
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
| vaadin-email-field | [EmailField](https://vaadin.com/docs/latest/ds/components/date-time-picker) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | minlength |  |
|  |  | maxlength |  |
|  |  | pattern |  |
|  |  | prevent-invalid-input |  |
|  |  | clear-button-visible |  |
| vaadin-number-field | [NumberField](https://vaadin.com/docs/latest/ds/components/number-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | min |  |
|  |  | max |  |
|  |  | step |  |
|  |  | has-controls |  |
|  |  | clear-button-visible |  |
| vaadin-integer-field | [IntegerField](https://vaadin.com/docs/latest/ds/components/number-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | min |  |
|  |  | max |  |
|  |  | step |  |
|  |  | has-controls |  |
|  |  | clear-button-visible |  |
| vaadin-big-decimal-field | [BigDecimalField](https://vaadin.com/docs/latest/ds/components/number-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | autofocus |  |
|  |  | autoselect |  |
|  |  | clear-button-visible |  |
| * | HasPrefixAndSuffix |  | Slots: prefix, suffix |
| vaadin-time-picker | [TimePicker](https://vaadin.com/components/vaadin-text-field) |  |  |
|  |  | label |  |
|  |  | placeholder |  |
|  |  | min | ISO-8601 formatted local time, e.g. 10:15 10:15:30 |
|  |  | max | ISO-8601 formatted local time, e.g. 10:15 10:15:30 |
|  |  | step |  |
|  |  | clear-button-visible |  |
| vaadin-upload | [Upload](https://vaadin.com/docs/latest/ds/components/upload) |  | Slots: add-button, drop-label, drop-label-icon |
|  |  | nodrop |  |
|  |  | accept |  |
|  |  | max-files |  |
|  |  | max-file-size |  |
|  |  | capture |  |
|  |  |  |  |
|  |  |  |  |
| vaadin-accordion | [Accordion](https://vaadin.com/docs/latest/ds/components/accordion) |  | Only vaadin-accordion-panel as child elements. |
|  |  | ! closed |  |
| vaadin-accordion-panel | AccordionPanel |  | Slots: summary |
| vaadin-avatar | [Avatar](https://vaadin.com/docs/latest/ds/components/avatar) |  |  |
|  |  | name |  |
|  |  | abbr |  |
|  |  | img |  |
|  |  | color-index |  |
| vaadin-avatar-group | [Avatar](https://vaadin.com/docs/latest/ds/components/avatar) |  |  |
|  |  | max-items-visible |  |
| vaadin-button | [Button](https://vaadin.com/docs/latest/ds/components/button) |  |  |
|  |  | autofocus |  |
|  |  | disable-on-click | Slots: prefix, suffix (only one is supported; limit of the Java Component) |
| vaadin-details | [Details](https://vaadin.com/docs/latest/ds/components/details) |  | Slots: summary |
|  |  | opened |  |
| vaadin-dialog | [Dialog](https://vaadin.com/docs/latest/ds/components/dialog) |  |  |
|  |  | no-close-on-esc |  |
|  |  | no-close-on-outside-click |  |
| vaadin-grid | [Grid](https://vaadin.com/docs/latest/ds/components/grid) |  | No children; use Java API. |
| ! vaadin-tree-grid | [TreeGrid](https://vaadin.com/docs/latest/ds/components/grid) |  | No children; use Java API. |
| vaadin-icon | [Icon](https://vaadin.com/docs/latest/ds/foundation/icons) |  |  |
|  |  | icon |  |
|  |  | ! color |  |
|  |  | ! size |  |
| vaadin-menu-bar | [MenuBar](https://vaadin.com/docs/latest/ds/components/menu-bar) |  |  |
|  |  | open-on-hover |  |
| vaadin-progress-bar | [ProgressBar](https://vaadin.com/docs/latest/ds/components/progress-bar) |  |  |
|  |  | indeterminate |  |
|  |  | min |  |
|  |  | max |  |
|  |  | value |  |
| vaadin-tabs | [Tabs](https://vaadin.com/docs/latest/ds/components/tabs) |  | Only vaadin-tab as child elements. |
|  |  | orientation | orientation="vertical" |
|  |  | selected |  |
| vaadin-tab | Tab |  |  |
|  |  |  |  |
|  |  |  |  |
| vaadin-app-layout | [AppLayout](https://vaadin.com/docs/latest/ds/components/app-layout) |  | Slots: navbar (touch-optimized), drawer |
|  |  | primary-section |  | navbar, drawer
| vaadin-drawer-toggle | [DrawerToggle](https://vaadin.com/docs/latest/ds/components/app-layout) |  |  |
| vaadin-form-layout | [FormLayout](https://vaadin.com/docs/latest/ds/components/form-layout) |  |  |
|  |  | ! colspan | Attribute for child elements! |
| vaadin-form-item |  |  | Slots: label |
| vaadin-login-form | [LoginForm](https://vaadin.com/docs/latest/ds/components/login) |  |  |
| vaadin-login-overlay | [LoginOverlay](https://vaadin.com/docs/latest/ds/components/login) |  |  |
| vaadin-horizontal-layout | [HorizontalLayout](https://vaadin.com/docs/latest/ds/components/basic-layouts) |  | Default spacing of the Java component is removed per default. |
| vaadin-vertical-layout | [VerticalLayout](https://vaadin.com/docs/latest/ds/components/basic-layouts) |  | Default width, padding, spacing of the Java component is removed per default. |
| * | ThemableLayout |  |  |
|  |  | ! margin | active when attribute present; attribute has no value |
|  |  | ! padding | active when attribute present; attribute has no value |
|  |  | ! spacing | active when attribute present; also supports **xs**, **s**, **m** (default), **l**, **xl** |
|  |  | ! box-sizing | border-box, content-box |
| vaadin-scroller | [Scroller](https://vaadin.com/docs/latest/ds/components/scroller) |  |  |
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
| vaadin-split-layout | [SplitLayout](https://vaadin.com/docs/latest/ds/components/split-layout) |  |  |
|  |  | orientation | orientation="vertical" |
|  |  |  |  |
|  |  |  |  |
| vaadin-board | [Board](https://vaadin.com/docs/latest/ds/components/board) |  |  |
| vaadin-board-row | [Row](https://vaadin.com/docs/latest/ds/components/board) |  |  |
| vaadin-chart | [Chart](https://vaadin.com/docs/latest/ds/components/charts) |  |  |
| vaadin-cookie-consent | [CookieConsent](https://vaadin.com/docs/latest/ds/components/cookie-consent) |  |  |
|  |  | message |  |
|  |  | dismiss |  |
|  |  | learn-more |  |
|  |  | learn-more-link |  |
| vaadin-crud | [Crud](https://vaadin.com/docs/latest/ds/components/crud) |  |  |
| vaadin-grid-pro | [GridPro](https://vaadin.com/docs/latest/ds/components/grid-pro) |  |  |
| vaadin-rich-text-editor | [RichTextEditor](https://vaadin.com/docs/latest/ds/components/rich-text-editor) |  |  |
|  |  |  |  |
