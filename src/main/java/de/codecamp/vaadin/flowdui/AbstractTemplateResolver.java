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
  implements
    TemplateResolver
{

  /**
   * pattern to extract the HTML from a Polymer or LitElement template
   */
  public static final Pattern EMBEDDED_TEMPLATE_PATTERN =
      Pattern.compile("html`(.*?)`", Pattern.DOTALL);


  @Override
  public Optional<Document> resolveTemplateDocument(ClassLoader classLoader, String templateId)
  {
    InputStream inputStream = getInputStream(classLoader, templateId);
    if (inputStream == null)
      return Optional.empty();

    Document doc = readDocumentFromStream(inputStream);
    return Optional.of(doc);
  }

  protected abstract InputStream getInputStream(ClassLoader classLoader, String templateId);


  /**
   * Reads the document from the given input stream.
   *
   * @param inputStream
   *          the input stream to be read
   * @return the document read from the stream
   * @throws TemplateException
   *           if the stream could not be loaded into a document
   */
  public static Document readDocumentFromStream(InputStream inputStream)
  {
    try (InputStream is = inputStream)
    {
      String docText = IOUtils.toString(is, StandardCharsets.UTF_8);
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
