package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.icon.VaadinIcon;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class IconFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "icon":
      case "iron-icon":
        String attrIcon = context.readStringAttribute(element, "icon", null, consumedAttributes);

        if (attrIcon != null && attrIcon.contains(":"))
        {
          String[] attrIconTokens = attrIcon.split(":", 2);
          IronIcon icon = new IronIcon(attrIconTokens[0], attrIconTokens[1]);
          context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "color",
              icon::setColor, consumedAttributes);
          context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "size",
              icon::setSize, consumedAttributes);
          return icon;
        }
        else
        {
          Icon icon;
          if (attrIcon == null)
          {
            icon = new Icon();
          }
          else
          {
            try
            {
              icon = VaadinIcon.valueOf(attrIcon).create();
            }
            catch (IllegalArgumentException ex)
            {
              icon = new Icon(attrIcon);
            }
          }

          context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "color",
              icon::setColor, consumedAttributes);
          context.readStringAttribute(element, TemplateParserContext.CUSTOM_ATTR_PREFIX + "size",
              icon::setSize, consumedAttributes);
          return icon;
        }
    }

    return null;
  }

}
