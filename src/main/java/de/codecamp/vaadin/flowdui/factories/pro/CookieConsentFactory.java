package de.codecamp.vaadin.flowdui.factories.pro;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.cookieconsent.CookieConsent;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;


public class CookieConsentFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-cookie-consent":
        CookieConsent cookieConsent = new CookieConsent();
        context.readStringAttribute(element, "message", cookieConsent::setMessage,
            consumedAttributes);
        context.readStringAttribute(element, "dismiss", cookieConsent::setDismissLabel,
            consumedAttributes);
        context.readStringAttribute(element, "learn-more", cookieConsent::setLearnMoreLabel,
            consumedAttributes);
        context.readStringAttribute(element, "learn-more-link", cookieConsent::setLearnMoreLink,
            consumedAttributes);
        return cookieConsent;
    }

    return null;
  }

}
