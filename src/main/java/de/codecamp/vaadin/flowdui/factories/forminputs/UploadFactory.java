package de.codecamp.vaadin.flowdui.factories.forminputs;

import java.util.Set;

import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.upload.Upload;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.TemplateParseContext;
import de.codecamp.vaadin.flowdui.TemplateException;


public class UploadFactory
  implements ComponentFactory
{

  @Override
  public Component createComponent(Element element, TemplateParseContext context,
      Set<String> consumedAttributes)
  {
    switch (element.tagName())
    {
      case "vaadin-upload":
        Upload upload = new Upload();
        context.readBooleanAttribute(element, "nodrop", v -> upload.setDropAllowed(!v),
            consumedAttributes);
        context.readStringAttribute(element, "accept",
            v -> upload.setAcceptedFileTypes(v.split(",")), consumedAttributes);
        context.readIntegerAttribute(element, "max-files", upload::setMaxFiles, consumedAttributes);
        context.readIntegerAttribute(element, "max-file-size", upload::setMaxFileSize,
            consumedAttributes);
        context.readStringAttribute(element, "capture",
            v -> upload.getElement().setAttribute("capture", v), consumedAttributes);

        context.readChildren(element, (slotName, childElement) -> {
          if (slotName == null)
            return false;
          switch (slotName)
          {
            case "add-button":
              if (upload.getUploadButton() != null)
                throw new TemplateException(element, "Slot 'add-button' already filled.");
              upload.setUploadButton(context.readComponentForSlot(childElement, null));
              return true;
            case "drop-label":
              if (upload.getDropLabel() != null)
                throw new TemplateException(element, "Slot 'drop-label' already filled.");
              upload.setDropLabel(context.readComponentForSlot(childElement, null));
              return true;
            case "drop-label-icon":
              if (upload.getDropLabelIcon() != null)
                throw new TemplateException(element, "Slot 'drop-label-icon' already filled.");
              upload.setDropLabelIcon(context.readComponentForSlot(childElement, null));
              return true;
            default:
              return false;
          }
        }, null);
        return upload;
    }

    return null;
  }

}
