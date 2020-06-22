package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class IconFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "iron-icon":
        String attrIcon = context.readStringAttribute(element, "icon", null, consumedAttributes);
        String[] attrIconTokens = attrIcon != null ? attrIcon.split(":", 2) : null;
        if (attrIconTokens == null || attrIconTokens.length != 2)
        {
          throw new TemplateException(element,
              "Attribute 'icon' of iron-icon must have the format 'collection:icon'.");
        }
        Icon icon = new Icon(attrIconTokens[0], attrIconTokens[1]);

        context.readStringAttribute(element, TemplateParseContext.CUSTOM_ATTR_PREFIX + "color",
            icon::setColor, consumedAttributes);
        context.readStringAttribute(element, TemplateParseContext.CUSTOM_ATTR_PREFIX + "size",
            icon::setSize, consumedAttributes);
        return icon;
    }

    return null;
  }

}
