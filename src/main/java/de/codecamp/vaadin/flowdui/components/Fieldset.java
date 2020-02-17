package de.codecamp.vaadin.flowdui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.dom.Element;


/**
 * An HTML {@code <fieldset>} styled to match the Vaadin Lumo theme. It essentially provides a
 * border and label for a group of components.
 */
@CssImport("./styles/fieldset.css")
public class Fieldset
  extends HtmlContainer
{

  private Element legend;


  public Fieldset()
  {
    super("fieldset");
  }


  public void setLegend(String legendText)
  {
    getLegend().setText(legendText);
  }

  public void setLegend(Component legendComponent)
  {
    Element legend = getLegend();
    legend.removeAllChildren();
    legend.appendChild(legendComponent.getElement());
  }

  private Element getLegend()
  {
    if (legend == null)
    {
      legend = new Element("legend");
      getElement().insertChild(0, legend);
    }
    return legend;
  }

}
