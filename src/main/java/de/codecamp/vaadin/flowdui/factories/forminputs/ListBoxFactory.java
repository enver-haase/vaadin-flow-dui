package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.ListBoxBase;
import com.vaadin.flow.component.listbox.MultiSelectListBox;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateException;
import de.codecamp.vaadin.flowdui.TemplateParserContext;


public class ListBoxFactory
  implements
    ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParserContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-list-box":
        ListBoxBase<?, ?, ?> listBox;
        if (element.hasAttr("multiple"))
          listBox = new MultiSelectListBox<>();
        else
          listBox = new ListBox<>();

        context.readChildren(listBox, element, (slotName, childComponent) -> {
          throw new TemplateException(
              "ListBox/MultiSelectListBox cannot be populated using a template. Use its Java API instead.");
        }, null);

        return listBox;
    }

    return null;
  }

}
