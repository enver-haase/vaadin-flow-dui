package de.codecamp.vaadin.flowdui.factories.layouts;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;


public class LoginFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-login-form":
        LoginForm loginForm = new LoginForm();
        context.readChildren(element, null, null);
        return loginForm;

      case "vaadin-login-overlay":
        LoginOverlay loginOverlay = new LoginOverlay();
        context.readChildren(element, null, null);
        return loginOverlay;
    }

    return null;
  }

}
