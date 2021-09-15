package de.codecamp.vaadin.flowdui.fluent.forminputs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.upload.Receiver;
import com.vaadin.flow.component.upload.Upload;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;


public class FluentUpload
  extends FluentComponent<Upload, FluentUpload>
  implements
    FluentHasStyle<Upload, FluentUpload>,
    FluentHasSize<Upload, FluentUpload>
{

  public FluentUpload()
  {
    this(new Upload());
  }

  public FluentUpload(Upload component)
  {
    super(component);
  }


  public FluentUpload autoUpload(boolean autoUpload)
  {
    getComponent().setAutoUpload(autoUpload);
    return this;
  }

  public FluentUpload dropAllowed(boolean dropAllowed)
  {
    getComponent().setDropAllowed(dropAllowed);
    return this;
  }

  public FluentUpload dropLabel(Component dropLabel)
  {
    getComponent().setDropLabel(dropLabel);
    return this;
  }

  public FluentUpload dropLabelIcon(Component dropLabelIcon)
  {
    getComponent().setDropLabelIcon(dropLabelIcon);
    return this;
  }

  public FluentUpload uploadButton(Component uploadButton)
  {
    getComponent().setUploadButton(uploadButton);
    return this;
  }

  public FluentUpload acceptedFileTypes(String... acceptedFileTypes)
  {
    getComponent().setAcceptedFileTypes(acceptedFileTypes);
    return this;
  }

  public FluentUpload maxFiles(int maxFiles)
  {
    getComponent().setMaxFiles(maxFiles);
    return this;
  }

  public FluentUpload maxFileSize(int maxFileSize)
  {
    getComponent().setMaxFileSize(maxFileSize);
    return this;
  }

  public FluentUpload receiver(Receiver receiver)
  {
    getComponent().setReceiver(receiver);
    return this;
  }

}
