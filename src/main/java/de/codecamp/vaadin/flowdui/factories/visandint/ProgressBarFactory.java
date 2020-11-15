package de.codecamp.vaadin.flowdui.factories.visandint;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.progressbar.ProgressBar;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class ProgressBarFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-progress-bar":
        ProgressBar progressBar = new ProgressBar();
        context.readBooleanAttribute(element, "indeterminate", progressBar::setIndeterminate,
            consumedAttributes);
        context.readDoubleAttribute(element, "min", progressBar::setMin, consumedAttributes);
        context.readDoubleAttribute(element, "max", progressBar::setMax, consumedAttributes);
        context.readDoubleAttribute(element, "value", progressBar::setValue, consumedAttributes);
        context.readChildren(progressBar, element, null, null);
        return progressBar;
    }

    return null;
  }

}
