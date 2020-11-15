package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.HasAutocapitalize;
import com.vaadin.flow.component.textfield.HasAutocomplete;
import com.vaadin.flow.component.textfield.HasAutocorrect;
import com.vaadin.flow.component.textfield.HasPrefixAndSuffix;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class TextFieldFactory
  implements ComponentFactory, ComponentPostProcessor
{

  private static final Map<String, Autocapitalize> autocapitalizeEnumMapping = new HashMap<>();
  static
  {
    autocapitalizeEnumMapping.put("none", Autocapitalize.NONE);
    autocapitalizeEnumMapping.put("sentences", Autocapitalize.SENTENCES);
    autocapitalizeEnumMapping.put("words", Autocapitalize.WORDS);
    autocapitalizeEnumMapping.put("characters", Autocapitalize.CHARACTERS);
  }

  private static final Map<String, Autocomplete> autocompleteEnumMapping = new HashMap<>();
  static
  {
    try
    {
      Field valueField = Autocomplete.class.getDeclaredField("value");
      valueField.setAccessible(true);
      for (Autocomplete a : Autocomplete.values())
      {
        String value = (String) valueField.get(a);
        autocompleteEnumMapping.put(value, a);
      }
    }
    catch (NoSuchFieldException | IllegalAccessException | RuntimeException ex)
    {
      throw new TemplateException("Failed to extract possible attribute values from Autocomplete.",
          ex);
    }
  }


  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    Component component = null;
    switch (element.tagName())
    {
      case "vaadin-text-field":
        TextField textField = new TextField();
        context.readStringAttribute(element, "label", textField::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", textField::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "autofocus", textField::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element, "autoselect", textField::setAutoselect,
            consumedAttributes);
        context.readIntegerAttribute(element, "minlength", textField::setMinLength,
            consumedAttributes);
        context.readIntegerAttribute(element, "maxlength", textField::setMaxLength,
            consumedAttributes);
        context.readStringAttribute(element, "pattern", textField::setPattern, consumedAttributes);
        context.readBooleanAttribute(element, "prevent-invalid-input",
            textField::setPreventInvalidInput, consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            textField::setClearButtonVisible, consumedAttributes);
        component = textField;
        break;

      case "vaadin-text-area":
        TextArea textArea = new TextArea();
        context.readStringAttribute(element, "label", textArea::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", textArea::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "autofocus", textArea::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element, "autoselect", textArea::setAutoselect,
            consumedAttributes);
        context.readIntegerAttribute(element, "minlength", textArea::setMinLength,
            consumedAttributes);
        context.readIntegerAttribute(element, "maxlength", textArea::setMaxLength,
            consumedAttributes);
        context.readBooleanAttribute(element, "prevent-invalid-input",
            textArea::setPreventInvalidInput, consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            textArea::setClearButtonVisible, consumedAttributes);
        component = textArea;
        break;

      case "vaadin-password-field":
        PasswordField passwordField = new PasswordField();
        context.readStringAttribute(element, "label", passwordField::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", passwordField::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "autofocus", passwordField::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element, "autoselect", passwordField::setAutoselect,
            consumedAttributes);
        context.readIntegerAttribute(element, "minlength", passwordField::setMinLength,
            consumedAttributes);
        context.readIntegerAttribute(element, "maxlength", passwordField::setMaxLength,
            consumedAttributes);
        context.readStringAttribute(element, "pattern", passwordField::setPattern,
            consumedAttributes);
        context.readBooleanAttribute(element, "prevent-invalid-input",
            passwordField::setPreventInvalidInput, consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            passwordField::setClearButtonVisible, consumedAttributes);
        context.readBooleanAttribute(element, "reveal-button-hidden",
            v -> passwordField.setRevealButtonVisible(!v), consumedAttributes);
        component = passwordField;
        break;

      case "vaadin-email-field":
        EmailField emailField = new EmailField();
        context.readStringAttribute(element, "label", emailField::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", emailField::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "autofocus", emailField::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element, "autoselect", emailField::setAutoselect,
            consumedAttributes);
        context.readIntegerAttribute(element, "minlength", emailField::setMinLength,
            consumedAttributes);
        context.readIntegerAttribute(element, "maxlength", emailField::setMaxLength,
            consumedAttributes);
        context.readStringAttribute(element, "pattern", emailField::setPattern, consumedAttributes);
        context.readBooleanAttribute(element, "prevent-invalid-input",
            emailField::setPreventInvalidInput, consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            emailField::setClearButtonVisible, consumedAttributes);
        component = emailField;
        break;

      case "vaadin-number-field":
        NumberField numberField = new NumberField();
        context.readStringAttribute(element, "label", numberField::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", numberField::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "autofocus", numberField::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element, "autoselect", numberField::setAutoselect,
            consumedAttributes);
        context.readDoubleAttribute(element, "min", numberField::setMin, consumedAttributes);
        context.readDoubleAttribute(element, "max", numberField::setMax, consumedAttributes);
        context.readDoubleAttribute(element, "step", numberField::setStep, consumedAttributes);
        context.readBooleanAttribute(element, "has-controls", numberField::setHasControls,
            consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            numberField::setClearButtonVisible, consumedAttributes);
        component = numberField;
        break;

      case "vaadin-integer-field":
        IntegerField integerField = new IntegerField();
        context.readStringAttribute(element, "label", integerField::setLabel, consumedAttributes);
        context.readStringAttribute(element, "placeholder", integerField::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "autofocus", integerField::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element, "autoselect", integerField::setAutoselect,
            consumedAttributes);
        context.readIntegerAttribute(element, "min", integerField::setMin, consumedAttributes);
        context.readIntegerAttribute(element, "max", integerField::setMax, consumedAttributes);
        context.readIntegerAttribute(element, "step", integerField::setStep, consumedAttributes);
        context.readBooleanAttribute(element, "has-controls", integerField::setHasControls,
            consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            integerField::setClearButtonVisible, consumedAttributes);
        component = integerField;
        break;

      case "vaadin-big-decimal-field":
        BigDecimalField bigDecimalField = new BigDecimalField();
        context.readStringAttribute(element, "label", bigDecimalField::setLabel,
            consumedAttributes);
        context.readStringAttribute(element, "placeholder", bigDecimalField::setPlaceholder,
            consumedAttributes);
        context.readBooleanAttribute(element, "autofocus", bigDecimalField::setAutofocus,
            consumedAttributes);
        context.readBooleanAttribute(element, "autoselect", bigDecimalField::setAutoselect,
            consumedAttributes);
        context.readBooleanAttribute(element, "clear-button-visible",
            bigDecimalField::setClearButtonVisible, consumedAttributes);
        component = bigDecimalField;
        break;
    }

    if (component instanceof HasPrefixAndSuffix)
    {
      HasPrefixAndSuffix hasPrefixAndSuffix = (HasPrefixAndSuffix) component;
      context.readChildren(component, element, (slotName, childElement) -> {
        if (slotName == null)
          return false;
        switch (slotName)
        {
          case "prefix":
            if (hasPrefixAndSuffix.getPrefixComponent() != null)
              throw new TemplateException(element, "Slot 'prefix' already filled.");

            hasPrefixAndSuffix.setPrefixComponent(context.readComponentForSlot(childElement, null));
            return true;
          case "suffix":
            if (hasPrefixAndSuffix.getSuffixComponent() != null)
              throw new TemplateException(element, "Slot 'suffix' already filled.");

            hasPrefixAndSuffix.setSuffixComponent(context.readComponentForSlot(childElement, null));
            return true;
          default:
            return false;
        }
      }, null);
    }
    else if (component != null)
    {
      context.readChildren(component, element, null, null);
    }

    return component;
  }

  @Override
  public void postProcessComponent(Component component, Element element,
      TemplateParserContext context, Set<String> consumedAttributes)
  {
    if (component instanceof HasAutocorrect)
    {
      if (element.hasAttr(HasAutocorrect.AUTOCORRECT_ATTRIBUTE))
      {
        String valueString = element.attr(HasAutocorrect.AUTOCORRECT_ATTRIBUTE);

        boolean value = false;
        if (valueString.equals("on"))
        {
          value = true;
        }
        else if (valueString.equals("off"))
        {
          value = false;
        }
        else
        {
          String msg = "Illegal value for attribute '%s' found: %s";
          msg = String.format(msg, HasAutocorrect.AUTOCORRECT_ATTRIBUTE, valueString);
          throw new TemplateException(element, msg);
        }

        ((HasAutocorrect) component).setAutocorrect(value);

        consumedAttributes.add(HasAutocorrect.AUTOCORRECT_ATTRIBUTE);
      }
    }
    if (component instanceof HasAutocapitalize)
    {
      HasAutocapitalize hasAutocapitalize = (HasAutocapitalize) component;
      context.readEnumAttribute(element, HasAutocapitalize.AUTOCAPITALIZE_ATTRIBUTE,
          autocapitalizeEnumMapping::get, hasAutocapitalize::setAutocapitalize, consumedAttributes);
    }
    if (component instanceof HasAutocomplete)
    {
      HasAutocomplete hasAutocomplete = (HasAutocomplete) component;
      context.readEnumAttribute(element, HasAutocomplete.AUTOCOMPLETE_ATTRIBUTE,
          autocompleteEnumMapping::get, hasAutocomplete::setAutocomplete, consumedAttributes);
    }
  }

}
