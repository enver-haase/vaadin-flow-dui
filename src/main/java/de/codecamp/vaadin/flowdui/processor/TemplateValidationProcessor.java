package de.codecamp.vaadin.flowdui.processor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;

import de.codecamp.vaadin.flowdui.FragmentId;
import de.codecamp.vaadin.flowdui.Mapped;
import de.codecamp.vaadin.flowdui.Slotted;


@AutoService(Processor.class)
public class TemplateValidationProcessor
  extends AbstractProcessor
{

  @Override
  public SourceVersion getSupportedSourceVersion()
  {
    return SourceVersion.latest();
  }

  @Override
  public Set<String> getSupportedAnnotationTypes()
  {
    return new HashSet<>(
        Arrays.asList(Mapped.class.getName(), Slotted.class.getName(), FragmentId.class.getName()));
  }


  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
  {

    // build set of template host types

    // + Slotted, FragmentId
    for (Element element : roundEnv.getElementsAnnotatedWith(Mapped.class))
    {
      TypeElement typeElement = (TypeElement) element.getEnclosingElement();
    }

    // validate template host types against parsed template
    // only works with default template resource names

    // how can validation of fragments work? how can one find the host for the fragment or vice
    // versa? assume that fragment host types are nested types of template host? so we have all
    // fragment host types and all fragments, but there's still no mapping between them.

    return false;
  }

}
