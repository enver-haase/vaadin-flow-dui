package de.codecamp.vaadin.flowdui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.internal.ReflectTools;
import com.vaadin.flow.server.VaadinService;

import de.codecamp.vaadin.flowdui.components.Slot;
import de.codecamp.vaadin.flowdui.factories.BasicFlowPostProcessor;
import de.codecamp.vaadin.flowdui.factories.CustomElementsFactory;
import de.codecamp.vaadin.flowdui.factories.FocusablePostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasEnabledPostProcessor;
import de.codecamp.vaadin.flowdui.factories.HasHelperPostProcessor;
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
import de.codecamp.vaadin.flowdui.factories.forminputs.DateTimePickerFactory;
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


public class TemplateEngine
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
    DEFAULT_POST_PROCESSORS.add(new HasHelperPostProcessor());

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
    DEFAULT_FACTORIES.add(new DateTimePickerFactory());
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


    // Pro components might not be present
    if (classExists("com.vaadin.flow.component.board.Board"))
      DEFAULT_FACTORIES.add(new BoardFactory());
    if (classExists("com.vaadin.flow.component.crud.Crud"))
      DEFAULT_FACTORIES.add(new CrudFactory());
    if (classExists("com.vaadin.flow.component.charts.Chart"))
      DEFAULT_FACTORIES.add(new ChartFactory());
  }

  private static final List<TemplateResolver> DEFAULT_RESOLVERS = new ArrayList<>();
  static
  {
    DEFAULT_RESOLVERS.add(new ClassPathTemplateResolver());
  }

  private static final List<ComponentFactory> ADDITIONAL_FACTORIES = new ArrayList<>();

  private static final List<ComponentPostProcessor> ADDITIONAL_POST_PROCESSORS = new ArrayList<>();

  private static final List<TemplateResolver> ADDITIONAL_RESOLVERS = new ArrayList<>();

  private static CacheMode defaultCacheMode = CacheMode.AUTO;


  private List<ComponentFactory> factories = new ArrayList<>();

  private List<ComponentPostProcessor> processors = new ArrayList<>();

  private List<TemplateResolver> resolvers = new ArrayList<>();

  private CacheMode cacheMode;

  private ConcurrentMap<String, Document> templateCache = new ConcurrentHashMap<>();


  public TemplateEngine()
  {
    this(ADDITIONAL_FACTORIES, ADDITIONAL_POST_PROCESSORS, ADDITIONAL_RESOLVERS);
  }

  public TemplateEngine(List<ComponentFactory> additionalFactories,
      List<ComponentPostProcessor> additionalPostProcessors,
      List<TemplateResolver> additionalResolvers)
  {
    this.factories =
        additionalFactories == null ? new ArrayList<>() : new ArrayList<>(additionalFactories);
    this.processors = additionalPostProcessors == null ? new ArrayList<>()
        : new ArrayList<>(additionalPostProcessors);
    this.resolvers =
        additionalResolvers == null ? new ArrayList<>() : new ArrayList<>(additionalResolvers);


    this.factories.addAll(ADDITIONAL_FACTORIES);
    this.processors.addAll(ADDITIONAL_POST_PROCESSORS);
    this.resolvers.addAll(ADDITIONAL_RESOLVERS);

    this.factories.addAll(DEFAULT_FACTORIES);
    this.processors.addAll(DEFAULT_POST_PROCESSORS);
    this.resolvers.addAll(DEFAULT_RESOLVERS);

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
   * Returns the list of additional {@link TemplateResolver template resolvers}. This list can be
   * edited to extend the list of supported attributes. Please note that the Spring Boot integration
   * provides a better way to do this.
   *
   * @return the list of additional {@link TemplateResolver template resolvers}
   */
  public static List<TemplateResolver> getAdditionalResolvers()
  {
    return ADDITIONAL_RESOLVERS;
  }

  /**
   * Sets the default cache mode for new {@link TemplateEngine} instances. Please note that
   * the Spring Boot integration provides a better way to do this.
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
   * Returns a {@link TemplateEngine}. This method requires the
   * {@link VaadinService#getCurrent()} to be available.
   *
   * @return a {@link TemplateEngine}
   */
  static TemplateEngine get()
  {
    return VaadinService.getCurrent().getInstantiator().getOrCreate(TemplateEngine.class);
  }


  /**
   * Reads a template for the given template ID and returns the root component.
   *
   * @param host
   *          the host object (component or otherwise) that is used for the component mapping; the
   *          associated class loader may also be used to load the template document
   * @param templateId
   *          the template ID is used by the {@link TemplateResolver} to find and load the template
   *          document
   * @return the root component of the processed template
   * @throws TemplateException
   *           if the template could not be successfully read
   */
  public Component instantiateTemplate(Object host, String templateId)
    throws TemplateException
  {
    Objects.requireNonNull(templateId, "templateId must not be null");

    Document document = getTemplateDocument(host.getClass(), templateId);

    ParsedTemplate parsedTemplate = parseTemplate(templateId, document);

    mapComponents(host, parsedTemplate);
    slotComponents(host, parsedTemplate);
    mapTemplateFragments(host, host.getClass(), parsedTemplate);

    return parsedTemplate.getRootComponent();
  }

  public Component instantiateTemplateFragment(Class<?> templateHostClass, String templateId,
      Object fragmentHost, String fragmentId)
    throws TemplateException
  {
    Objects.requireNonNull(templateId, "templateId must not be null");

    Document document = getTemplateDocument(templateHostClass, templateId);

    Elements select = document.select("template#" + fragmentId);
    if (select.isEmpty())
    {
      String msg = "No template fragment with ID '%s' found.";
      msg = String.format(msg, fragmentId);
      throw new TemplateException(msg);
    }
    if (select.size() > 1)
    {
      String msg = "More than one template fragment with ID '%s' found.";
      msg = String.format(msg, fragmentId);
      throw new TemplateException(msg);
    }

    Element templateFragment = select.first();

    ParsedTemplate parsedTemplate = parseTemplateFragment(templateId, templateFragment);

    if (fragmentHost != null)
    {
      mapComponents(fragmentHost, parsedTemplate);
      slotComponents(fragmentHost, parsedTemplate);
      mapTemplateFragments(fragmentHost, templateHostClass, parsedTemplate);
    }

    return parsedTemplate.getRootComponent();
  }

  protected ParsedTemplate parseTemplate(String templateId, Document templateDocument)
    throws TemplateException
  {
    TemplateParserContext context = new TemplateParserContext(templateId, factories, processors);

    context.parseTemplate(templateDocument);

    return new ParsedTemplate(context.getTemplateId(), context.getRootComponent(),
        context.getComponentsById(), context.getSlotsByName(), context.getTemplateFragmentById());
  }

  protected ParsedTemplate parseTemplateFragment(String templateId, Element fragmentElement)
    throws TemplateException
  {
    TemplateParserContext context = new TemplateParserContext(templateId, factories, processors);

    context.parseTemplateFragment(fragmentElement);

    return new ParsedTemplate(context.getTemplateId(), context.getRootComponent(),
        context.getComponentsById(), context.getSlotsByName(), null);
  }

  private Document getTemplateDocument(Class<?> hostClass, String templateId)
  {
    if (templateId == null || templateId.isEmpty())
      templateId = hostClass.getSimpleName();

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

    // muss templateId ganzen Pfad enthalten?
    Document document;
    if (useCache)
    {
      document =
          templateCache.computeIfAbsent(templateId, tid -> resolveTemplateDocument(hostClass, tid));
    }
    else
    {
      document = resolveTemplateDocument(hostClass, templateId);
    }
    return document;
  }

  private Document resolveTemplateDocument(Class<?> hostClass, String templateId)
  {
    if (resolvers == null || resolvers.isEmpty())
      throw new IllegalStateException("No TemplateResolvers registered.");

    Document document = null;
    for (TemplateResolver loader : resolvers)
    {
      document = loader.resolveTemplateDocument(hostClass, templateId).orElse(null);
      if (document != null)
        break;
    }

    if (document == null)
    {
      String msg = "No document found for template '%s' and host class '%s'.";
      msg = String.format(msg, templateId, hostClass.getName());
      throw new TemplateException(msg);
    }

    return document;
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

  public static void mapTemplateFragments(Object host, Class<?> templateHostClass,
      ParsedTemplate template)
  {
    for (Field field : host.getClass().getDeclaredFields())
    {
      String fragmentId = null;

      FragmentId fragmentAt = field.getAnnotation(FragmentId.class);
      if (fragmentAt != null)
      {
        fragmentId = fragmentAt.value();
      }

      if (fragmentId == null)
        continue;

      if (fragmentId.isEmpty())
        fragmentId = field.getName();

      Element fragmentElement = template.getTemplateFragmentById(fragmentId);
      if (fragmentElement == null)
      {
        String msg = "No template fragment found with ID '%s' for field %s.";
        msg = String.format(msg, fragmentId, field);
        throw new TemplateException(msg);
      }

      TemplateFragment templateFragment =
          new TemplateFragment(templateHostClass, template.getTemplateResourceName(), fragmentId);

      ReflectTools.setJavaFieldValue(host, field, templateFragment);
    }
  }

  private static boolean classExists(String className)
  {
    try
    {
      Class.forName(className);
      return true;
    }
    catch (ClassNotFoundException ex)
    {
      return false;
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
