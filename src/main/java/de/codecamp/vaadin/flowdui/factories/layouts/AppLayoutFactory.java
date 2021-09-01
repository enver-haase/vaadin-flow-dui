package de.codecamp.vaadin.flowdui.factories.layouts;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayout.Section;
import com.vaadin.flow.component.applayout.DrawerToggle;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class AppLayoutFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-app-layout":
        AppLayout appLayout = new AppLayout();
        context.readEnumAttribute(element, "primary-section", Section::fromWebcomponentValue,
            appLayout::setPrimarySection, null);
        context.readChildren(appLayout, element, (slotName, childElement) -> {
          if (slotName == null)
          {
            if (appLayout.getContent() != null)
              throw new TemplateException(childElement, "Only one content component supported.");

            appLayout.setContent(context.readComponent(childElement, null));
            return true;
          }
          boolean touchOptimized = false;
          if (slotName.contains("touch-optimized"))
          {
            touchOptimized = true;
            slotName = slotName.replace("touch-optimized", "").trim();
          }
          switch (slotName)
          {
            case "navbar":
              appLayout.addToNavbar(touchOptimized,
                  context.readComponentForSlot(childElement, null));
              return true;
            case "drawer":
              appLayout.addToDrawer(context.readComponentForSlot(childElement, null));
              return true;
            default:
              return false;
          }
        }, null);
        return appLayout;

      case "vaadin-drawer-toggle":
        DrawerToggle drawerToggle = new DrawerToggle();
        return drawerToggle;
    }

    return null;
  }

}
