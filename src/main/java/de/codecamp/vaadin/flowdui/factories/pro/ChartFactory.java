package de.codecamp.vaadin.flowdui.factories.pro;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class ChartFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-chart":
        Chart chart = new Chart();
        return chart;
    }

    return null;
  }

}
