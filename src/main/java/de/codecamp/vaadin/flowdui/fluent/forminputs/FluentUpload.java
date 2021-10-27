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
    get().setAutoUpload(autoUpload);
    return this;
  }

  public FluentUpload dropAllowed(boolean dropAllowed)
  {
    get().setDropAllowed(dropAllowed);
    return this;
  }

  public FluentUpload dropLabel(Component dropLabel)
  {
    get().setDropLabel(dropLabel);
    return this;
  }

  public FluentUpload dropLabelIcon(Component dropLabelIcon)
  {
    get().setDropLabelIcon(dropLabelIcon);
    return this;
  }

  public FluentUpload uploadButton(Component uploadButton)
  {
    get().setUploadButton(uploadButton);
    return this;
  }

  public FluentUpload acceptedFileTypes(String... acceptedFileTypes)
  {
    get().setAcceptedFileTypes(acceptedFileTypes);
    return this;
  }

  public FluentUpload maxFiles(int maxFiles)
  {
    get().setMaxFiles(maxFiles);
    return this;
  }

  public FluentUpload maxFileSize(int maxFileSize)
  {
    get().setMaxFileSize(maxFileSize);
    return this;
  }

  public FluentUpload receiver(Receiver receiver)
  {
    get().setReceiver(receiver);
    return this;
  }

}
