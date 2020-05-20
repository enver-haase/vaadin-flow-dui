package de.codecamp.vaadin.flowdui;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.internal.ReflectTools;
import com.vaadin.flow.server.VaadinService;

import de.codecamp.vaadin.flowdui.components.Slot;
import de.codecamp.vaadin.flowdui.factories.BasicFlowPostProcessor;
import de.codecamp.vaadin.flowdui.factories.CustomElementsFactory;
import de.codecamp.vaadin.flowdui.factories.FocusablePostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasEnabledPostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasSizePostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasStylePostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasThemePostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasValidationPostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasValuePostProcessor;
import de.codecamp.vaadin.flowdui.factories.HtmlFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.CheckboxFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.ComboBoxFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.CustomFieldFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.DatePickerFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.ListBoxFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.RadioButtonFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.SelectFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.TextFieldFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.TimePickerFactory;
import de.codecamp.vaadin.flowdui.factories.forminputs.UploadFactory;
import de.codecamp.vaadin.flowdui.factories.layouts.AppLayoutFactory;
import de.codecamp.vaadin.flowdui.factories.layouts.FormLayoutFactory;
import de.codecamp.vaadin.flowdui.factories.layouts.LoginFactory;
import de.codecamp.vaadin.flowdui.factories.layouts.OrderedLayoutFactory;
import de.codecamp.vaadin.flowdui.factories.layouts.SplitLayoutFactory;
import de.codecamp.vaadin.flowdui.factories.pro.BoardFactory;
import de.codecamp.vaadin.flowdui.factories.pro.ChartFactory;
import de.codecamp.vaadin.flowdui.factories.pro.CrudFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.AccordionFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.ButtonFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.DetailsFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.DialogFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.GridFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.IconFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.MenuBarFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.ProgressBarFactory;
import de.codecamp.vaadin.flowdui.factories.visandint.TabsFactory;


public class TemplateBuilder
{

  private static final List<ComponentFactory> DEFAULT_FACTORIES = new ArrayList<>();

  private static final List<ComponentPostProcessor> DEFAULT_POST_PROCESSORS = new ArrayList<>();

  static
  {
    DEFAULT_POST_PROCESSORS.add(new BasicFlowPostProcessor());
    DEFAULT_POST_PROCESSORS.add(new HasEnabledPostProcessor());
    DEFAULT_POST_PROCESSORS.add(new HasSizePostProcessor());
    DEFAULT_POST_PROCESSORS.add(new FocusablePostProcessor());
    DEFAULT_POST_PROCESSORS.add(new HasStylePostProcessor());
    DEFAULT_POST_PROCESSORS.add(new HasThemePostProcessor());
    DEFAULT_POST_PROCESSORS.add(new HasValuePostProcessor());
    DEFAULT_POST_PROCESSORS.add(new HasValidationPostProcessor());

    DEFAULT_FACTORIES.add(new CustomElementsFactory());

    DEFAULT_FACTORIES.add(new HtmlFactory());

    // layouts
    DEFAULT_FACTORIES.add(new AppLayoutFactory());
    DEFAULT_FACTORIES.add(new FormLayoutFactory());
    DEFAULT_FACTORIES.add(new LoginFactory());
    OrderedLayoutFactory orderedLayoutFactory = new OrderedLayoutFactory();
    DEFAULT_FACTORIES.add(orderedLayoutFactory);
    DEFAULT_POST_PROCESSORS.add(orderedLayoutFactory);
    DEFAULT_FACTORIES.add(new SplitLayoutFactory());

    // form inputs
    DEFAULT_FACTORIES.add(new CheckboxFactory());
    DEFAULT_FACTORIES.add(new ComboBoxFactory());
    DEFAULT_FACTORIES.add(new CustomFieldFactory());
    DEFAULT_FACTORIES.add(new DatePickerFactory());
    DEFAULT_FACTORIES.add(new ListBoxFactory());
    DEFAULT_FACTORIES.add(new RadioButtonFactory());
    DEFAULT_FACTORIES.add(new SelectFactory());
    TextFieldFactory textFieldFlowFactory = new TextFieldFactory();
    DEFAULT_FACTORIES.add(textFieldFlowFactory);
    DEFAULT_POST_PROCESSORS.add(textFieldFlowFactory);
    DEFAULT_FACTORIES.add(new TimePickerFactory());
    DEFAULT_FACTORIES.add(new UploadFactory());

    // visualization & interaction
    DEFAULT_FACTORIES.add(new AccordionFactory());
    DEFAULT_FACTORIES.add(new ButtonFactory());
    DEFAULT_FACTORIES.add(new DetailsFactory());
    DEFAULT_FACTORIES.add(new DialogFactory());
    DEFAULT_FACTORIES.add(new GridFactory());
    DEFAULT_FACTORIES.add(new IconFactory());
    DEFAULT_FACTORIES.add(new MenuBarFactory());
    DEFAULT_FACTORIES.add(new ProgressBarFactory());
    DEFAULT_FACTORIES.add(new TabsFactory());

    DEFAULT_FACTORIES.add(new BoardFactory());
    DEFAULT_FACTORIES.add(new CrudFactory());
    DEFAULT_FACTORIES.add(new ChartFactory());
  }

  private static final List<ComponentFactory> ADDITIONAL_FACTORIES = new ArrayList<>();

  private static final List<ComponentPostProcessor> ADDITIONAL_POST_PROCESSORS = new ArrayList<>();

  private static CacheMode defaultCacheMode = CacheMode.AUTO;


  private List<ComponentFactory> factories = new ArrayList<>();

  private List<ComponentPostProcessor> processors = new ArrayList<>();


  private CacheMode cacheMode;

  private ConcurrentMap<String, Document> templateCache = new ConcurrentHashMap<>();


  public TemplateBuilder()
  {
    this(ADDITIONAL_FACTORIES, ADDITIONAL_POST_PROCESSORS);
  }

  public TemplateBuilder(List<ComponentFactory> additionalFactories,
      List<ComponentPostProcessor> additionalPostProcessors)
  {
    this.factories =
        additionalFactories == null ? new ArrayList<>() : new ArrayList<>(additionalFactories);
    this.processors = additionalPostProcessors == null ? new ArrayList<>()
        : new ArrayList<>(additionalPostProcessors);


    this.factories.addAll(ADDITIONAL_FACTORIES);
    this.processors.addAll(ADDITIONAL_POST_PROCESSORS);

    this.factories.addAll(DEFAULT_FACTORIES);
    this.processors.addAll(DEFAULT_POST_PROCESSORS);

    cacheMode = defaultCacheMode;
  }


  public CacheMode getCacheMode()
  {
    return cacheMode;
  }

  public void setCacheMode(CacheMode cacheMode)
  {
    Objects.requireNonNull(cacheMode, "CacheMode must not be null.");
    this.cacheMode = cacheMode;
  }


  /**
   * Returns the list of additional {@link ComponentFactory component factories}. This list can be
   * edited to extend the list of supported components. Please note that the Spring Boot integration
   * provides a better way to do this.
   *
   * @return the list of additional {@link ComponentFactory component factories}
   */
  public static List<ComponentFactory> getAdditionalFactories()
  {
    return ADDITIONAL_FACTORIES;
  }

  /**
   * Returns the list of additional {@link ComponentPostProcessor component post processors}. This
   * list can be edited to extend the list of supported attributes. Please note that the Spring Boot
   * integration provides a better way to do this.
   *
   * @return the list of additional {@link ComponentPostProcessor component post processors}
   */
  public static List<ComponentPostProcessor> getAdditionalPostProcessors()
  {
    return ADDITIONAL_POST_PROCESSORS;
  }

  /**
   * Sets the default cache mode for new {@link TemplateBuilder} instances. Please note that the
   * Spring Boot integration provides a better way to do this.
   *
   * @param cacheMode
   *          the default cache mode
   */
  public static void setDefaultCacheMode(CacheMode cacheMode)
  {
    Objects.requireNonNull(cacheMode, "CacheMode must not be null.");
    defaultCacheMode = cacheMode;
  }


  /**
   * Reads a template and returns the results. If no resource name for the template file is
   * provided, it will be assumed to be the same as the simple name of the component class with an
   * {@code .html} ending.
   *
   * @param hostComponent
   *          the component (or any object, really) that is used for the component mapping and used
   *          to determine the class loader used to load the template and optionally the resource
   *          name of the template
   * @param templateResourceName
   *          the resource name of the template file to load; if empty the name will be assumed to
   *          be the same as the simple name of the component class with an {@code .html} ending
   * @return the parsed template
   * @throws TemplateException
   *           if the template could not be successfully parsed
   */
  public Component readTemplate(Object hostComponent, String templateResourceName)
    throws TemplateException
  {
    String effectiveTemplateResourceName =
        (templateResourceName == null || templateResourceName.isEmpty())
            ? hostComponent.getClass().getSimpleName() + ".html"
            : templateResourceName;

    boolean useCache;
    switch (cacheMode)
    {
      case ALWAYS:
        useCache = true;
        break;

      case NEVER:
        useCache = false;
        break;

      default:
      case AUTO:
        boolean productionMode = Optional.ofNullable(VaadinService.getCurrent())
            .map(service -> service.getDeploymentConfiguration().isProductionMode()).orElse(false);
        useCache = productionMode;
        break;
    }

    Document document;
    if (useCache)
    {
      /*
       * Cache key should contain the full path. Resource names starting with '/' are absolute, all
       * others relative to the component class. So for the latter, prefix the package name.
       */
      String cacheKey =
          effectiveTemplateResourceName.startsWith("/") ? effectiveTemplateResourceName
              : hostComponent.getClass().getPackage().getName().replace('.', '/') + "/"
                  + effectiveTemplateResourceName;

      document = templateCache.computeIfAbsent(cacheKey,
          resname -> loadDocument(hostComponent.getClass(), effectiveTemplateResourceName));
    }
    else
    {
      document = loadDocument(hostComponent.getClass(), effectiveTemplateResourceName);
    }

    ParsedTemplate parsedTemplate = readTemplate(document);

    mapComponents(hostComponent, parsedTemplate);
    slotComponents(hostComponent, parsedTemplate);

    return parsedTemplate.getRootComponent();
  }

  public ParsedTemplate readTemplate(Document templateDoc)
    throws TemplateException
  {
    return readTemplate(templateDoc, new TemplateContext(factories, processors));
  }

  private ParsedTemplate readTemplate(Document templateDoc, TemplateContext context)
    throws TemplateException
  {
    Element body = templateDoc.body();

    context.readChildren(body, (slotName, childElement) -> {
      if (slotName != null)
        return false;

      if (context.getRootComponent() != null)
        throw new TemplateException("Template must have a single root element.");

      context.setRootComponent(context.readComponent(childElement, null));
      return true;
    }, null);

    return new ParsedTemplate(context.getRootComponent(), context.getComponentsById(),
        context.getSlotsByName());
  }

  private Document loadDocument(Class<?> componentClass, String templateResourceName)
  {
    InputStream inputStream = componentClass.getResourceAsStream(templateResourceName);
    if (inputStream == null)
    {
      String msg = "Template resource '%s' not found through classloader of class '%s'.";
      msg = String.format(msg, templateResourceName, componentClass.getName());
      throw new TemplateException(msg);
    }

    Document doc;
    try
    {
      String bodyHtml = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      doc = Jsoup.parseBodyFragment(bodyHtml);
    }
    catch (IOException ex)
    {
      throw new TemplateException("Failed to parse the design template resource.", ex);
    }
    return doc;
  }


  /**
   * Maps components from the given {@link ParsedTemplate} to the {@link Mapped}-annotated fields of
   * the given host object.
   *
   * @param host
   *          the host object
   * @param template
   *          the parsed template
   * @see Mapped
   */
  public static void mapComponents(Object host, ParsedTemplate template)
  {
    for (Field field : host.getClass().getDeclaredFields())
    {
      String componentId = null;

      Mapped mappedAt = field.getAnnotation(Mapped.class);
      if (mappedAt != null)
      {
        componentId = mappedAt.value();
      }
      else
      {
        Id idAt = field.getAnnotation(Id.class);
        if (idAt != null)
          componentId = idAt.value();
      }

      if (componentId == null)
        continue;

      if (componentId.isEmpty())
        componentId = field.getName();

      Component component = template.getComponentById(componentId);
      if (component == null)
      {
        String msg = "No component found with ID '%s' for field %s.";
        msg = String.format(msg, componentId, field);
        throw new TemplateException(msg);
      }

      ReflectTools.setJavaFieldValue(host, field, component);
    }
  }

  /**
   * Inserts components from the {@link Slotted}-annotated fields of the given host object into the
   * slots of the {@link ParsedTemplate template}.
   *
   * @param host
   *          the host object
   * @param template
   *          the parsed template
   * @see Slotted
   */
  public static void slotComponents(Object host, ParsedTemplate template)
  {
    Set<String> encounteredSlots = new HashSet<>();

    for (Field field : host.getClass().getDeclaredFields())
    {
      String slotName = "";

      boolean slotted = false;

      Slotted slottedAt = field.getAnnotation(Slotted.class);
      if (slottedAt != null)
      {
        slotName = slottedAt.value();
        slotted = true;
      }

      if (!slotted)
        continue;

      if (slotName.isEmpty())
        slotName = field.getName();


      Slot slot = template.getSlotByName(slotName);
      if (slot == null)
      {
        String msg = "Could not slot in component. Slot not found: %s";
        msg = String.format(msg, slotName);
        throw new TemplateException(msg);
      }
      /*
       * The child elements of the slot from the template are the default content. If a
       * matching @Slottable has been found, remove them completely. This should match the behavior
       * of the real Web Compoenent <slot>.
       */
      if (encounteredSlots.add(slotName))
      {
        slot.removeAll();
      }

      Component component;
      try
      {
        component = (Component) ReflectTools.getJavaFieldValue(host, field);
      }
      catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException ex)
      {
        throw new TemplateException("Unable to get the value from the field " + field.getName()
            + " in " + host.getClass().getName() + ".", ex);
      }
      if (component == null)
      {
        String msg = "No component set on field '%s' for slot '%s'.";
        msg = String.format(msg, field.getName(), slotName);
        throw new TemplateException(msg);
      }

      slot.add(component);
    }
  }


  public enum CacheMode
  {
    /**
     * Always cache loaded templates.
     */
    ALWAYS,

    /**
     * Never cache loaded templates.
     */
    NEVER,

    /**
     * Cache loaded templates when in production mode, otherwise don't.
     */
    AUTO
  }

}
