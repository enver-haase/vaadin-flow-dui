package de.codecamp.vaadin.flowdui.factories.layouts;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout.Orientation;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class SplitLayoutFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-split-layout":
        SplitLayout splitLayout = new SplitLayout();
        context.readStringAttribute(element, "orientation", v -> {
          if ("vertical".equals(v))
            splitLayout.setOrientation(Orientation.VERTICAL);
        }, consumedAttributes);

        AtomicInteger nextArea = new AtomicInteger(0);

        context.readChildren(element, (slotName, childElement) -> {
          if (slotName != null)
            return false;

          if (nextArea.get() >= 2)
            throw new TemplateException(element, "Both areas already filled.");

          Component childComponent = context.readComponent(childElement, null);

          if (nextArea.getAndIncrement() == 0)
            splitLayout.addToPrimary(childComponent);
          else
            splitLayout.addToSecondary(childComponent);

          return true;
        }, null);

        return splitLayout;
    }

    return null;
  }

}
