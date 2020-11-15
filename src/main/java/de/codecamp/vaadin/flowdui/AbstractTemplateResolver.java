package de.codecamp.vaadin.flowdui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public abstract class AbstractTemplateResolver
  implements TemplateResolver
{

  public static final Pattern EMBEDDED_TEMPLATE_PATTERN =
      Pattern.compile("html`(.*?)`", Pattern.DOTALL);


  @Override
  public Optional<Document> resolveTemplateDocument(Class<?> hostClass, String templateId)
  {
    InputStream inputStream = getInputStream(hostClass, templateId);
    if (inputStream == null)
      return Optional.empty();

    Document doc = readDocumentFromStream(inputStream);
    return Optional.of(doc);
  }

  protected abstract InputStream getInputStream(Class<?> hostClass, String templateId);


  public static Document readDocumentFromStream(InputStream inputStream)
  {
    try
    {
      String docText = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      Matcher matcher = EMBEDDED_TEMPLATE_PATTERN.matcher(docText);
      if (matcher.find())
        docText = matcher.group(1);

      return Jsoup.parseBodyFragment(docText);
    }
    catch (IOException ex)
    {
      throw new TemplateException("Failed to parse the template resource.", ex);
    }
  }

}
