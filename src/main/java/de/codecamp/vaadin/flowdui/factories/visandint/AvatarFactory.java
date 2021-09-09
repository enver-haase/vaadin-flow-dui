package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarGroup;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class AvatarFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-avatar":
        Avatar avatar = new Avatar();
        context.readStringAttribute(element, "name", avatar::setName, consumedAttributes);
        context.readStringAttribute(element, "abbr", avatar::setAbbreviation, consumedAttributes);
        context.readStringAttribute(element, "img", avatar::setImage, consumedAttributes);
        context.readIntegerAttribute(element, "color-index", avatar::setColorIndex,
            consumedAttributes);

        context.readChildren(avatar, element, null, null);

        return avatar;

      case "vaadin-avatar-group":
        AvatarGroup avatarGroup = new AvatarGroup();
        context.readIntegerAttribute(element, "max", avatarGroup::setMaxItemsVisible,
            consumedAttributes);
        context.readIntegerAttribute(element, "max-items-visible", avatarGroup::setMaxItemsVisible,
            consumedAttributes);

        context.readChildren(avatarGroup, element, null, null);

        return avatarGroup;
    }

    return null;
  }

}
