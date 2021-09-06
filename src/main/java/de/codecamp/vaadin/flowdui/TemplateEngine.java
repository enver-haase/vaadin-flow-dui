package de.codecamp.vaadin.flowdui;

import java.lang.reflect.Constructor;
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
import com.vaadin.flow.internal.AnnotationReader;
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
    registerDefaultFactory(new BasicFlowPostProcessor());
    registerDefaultFactory(new HasEnabledPostProcessor());
    registerDefaultFactory(new HasSizePostProcessor());
    registerDefaultFactory(new FocusablePostProcessor());
    registerDefaultFactory(new HasStylePostProcessor());
    registerDefaultFactory(new HasThemePostProcessor());
    registerDefaultFactory(new HasValuePostProcessor());
    registerDefaultFactory(new HasValidationPostProcessor());
    registerDefaultFactory(new HasHelperPostProcessor());

    registerDefaultFactory(new CustomElementsFactory());

    registerDefaultFactory(new HtmlFactory());

    // layouts
    registerDefaultFactory(new AppLayoutFactory());
    registerDefaultFactory(new FormLayoutFactory());
    registerDefaultFactory(new LoginFactory());
    registerDefaultFactory(new OrderedLayoutFactory());
    registerDefaultFactory(new SplitLayoutFactory());

    // form inputs
    registerDefaultFactory(new CheckboxFactory());
    registerDefaultFactory(new ComboBoxFactory());
    registerDefaultFactory(new CustomFieldFactory());
    registerDefaultFactory(new DatePickerFactory());
    registerDefaultFactory(new DateTimePickerFactory());
    registerDefaultFactory(new ListBoxFactory());
    registerDefaultFactory(new RadioButtonFactory());
    registerDefaultFactory(new SelectFactory());
    registerDefaultFactory(new TextFieldFactory());
    registerDefaultFactory(new TimePickerFactory());
    registerDefaultFactory(new UploadFactory());

    // visualization & interaction
    registerDefaultFactory(new AccordionFactory());
    registerDefaultFactory(new ButtonFactory());
    registerDefaultFactory(new DetailsFactory());
    registerDefaultFactory(new DialogFactory());
    registerDefaultFactory(new GridFactory());
    registerDefaultFactory(new IconFactory());
    registerDefaultFactory(new MenuBarFactory());
    registerDefaultFactory(new ProgressBarFactory());
    registerDefaultFactory(new TabsFactory());


    // Pro components might not be present
    if (classExists("com.vaadin.flow.component.board.Board"))
      registerDefaultFactory(new BoardFactory());
    if (classExists("com.vaadin.flow.component.crud.Crud"))
      registerDefaultFactory(new CrudFactory());
    if (classExists("com.vaadin.flow.component.charts.Chart"))
      registerDefaultFactory(new ChartFactory());
  }


  private static final void registerDefaultFactory(Object factory)
  {
    if (factory instanceof ComponentPostProcessor)
      DEFAULT_POST_PROCESSORS.add((ComponentPostProcessor) factory);

    if (factory instanceof ComponentFactory)
      DEFAULT_FACTORIES.add((ComponentFactory) factory);
  }


  private static final List<TemplateResolver> DEFAULT_RESOLVERS = new ArrayList<>();
  static
  {
    DEFAULT_RESOLVERS.add(new ClasspathTemplateResolver());
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
   * Sets the default cache mode for new {@link TemplateEngine} instances. Please note that the
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
   * Returns a {@link TemplateEngine}. This method requires the {@link VaadinService#getCurrent()}
   * to be available.
   *
   * @return a {@link TemplateEngine}
   */
  public static TemplateEngine get()
  {
    return VaadinService.getCurrent().getInstantiator().getOrCreate(TemplateEngine.class);
  }


  /**
   * Builds the component tree based on the template for the given {@link TemplateComposite}.
   * <p>
   * Components from the component tree can be {@link Mapped mapped} to fields of the composite.
   * Manually created components in fields of the composite can be {@link Slotted slotted} into the
   * component tree.
   * <p>
   * The template ID is assumed to be the fully qualified name of the subclass, unless an explict ID
   * is provided via {@link TemplateId}.
   *
   * @param templateHost
   *          the host object (component or otherwise) that is used for the component mapping; the
   *          associated class loader may also be used to load the template document; also used to
   *          determine the template ID
   * @return the root component of the created component tree
   * @throws TemplateException
   *           if the template could not be successfully processed
   * @see #mapComponents(Object, ParsedTemplate)
   * @see #slotComponents(Object, ParsedTemplate)
   */
  public Component instantiateTemplate(Object templateHost)
    throws TemplateException
  {
    Objects.requireNonNull(templateHost, "templateHost must not be null");

    String templateId = TemplateEngine.getTemplateId(templateHost.getClass());

    return instantiateTemplate(templateId, templateHost);
  }

  /**
   * Builds the component tree based on the template for the given template ID.
   * <p>
   * Components are {@link #mapComponents(Object, ParsedTemplate) mapped} and
   * {@link #slotComponents(Object, ParsedTemplate) slotted} on the given template host.
   *
   * @param templateId
   *          the template ID
   * @param templateHost
   *          the host object (component or otherwise) that is used for the component mapping; the
   *          associated class loader may also be used to load the template document
   * @return the root component of the processed template
   * @throws TemplateException
   *           if the template could not be successfully read
   * @see #mapComponents(Object, ParsedTemplate)
   * @see #slotComponents(Object, ParsedTemplate)
   */
  public Component instantiateTemplate(String templateId, Object templateHost)
    throws TemplateException
  {
    Objects.requireNonNull(templateHost, "templateHost must not be null");
    Objects.requireNonNull(templateId, "templateId must not be null");

    Document document = getTemplateDocument(templateHost.getClass().getClassLoader(), templateId);

    ParsedTemplate parsedTemplate = parseTemplate(templateId, document);

    mapComponents(templateHost, parsedTemplate);
    slotComponents(templateHost, parsedTemplate);

    return parsedTemplate.getRootComponent();
  }

  /**
   * Builds the component tree based on the template fragment for the given
   * {@link FragmentComposite}.
   * <p>
   * Components from the component tree can be {@link Mapped mapped} to fields of the composite.
   * Manually created components in fields of the composite can be {@link Slotted slotted} into the
   * component tree.
   * <p>
   * To ensure that the corresponding template can be determined, subclasses of
   * {@link FragmentComposite} either need to be inner classes of {@link TemplateComposite template
   * composites}, have any enclosing class annotated with {@link TemplateId} or be themselves
   * annotated with {@link TemplateId}.
   * <p>
   * The fragment ID is assumed to be the simple name of the subclass, unless an explict ID is
   * provided via {@link FragmentId}.
   *
   * @param fragmentComposite
   *          the {@link FragmentComposite} for which to build the component tree based on a
   *          template fragment
   * @return the root component of the created component tree
   * @throws TemplateException
   *           if the template could not be successfully processed
   * @see #mapComponents(Object, ParsedTemplate)
   * @see #slotComponents(Object, ParsedTemplate)
   */
  public Component instantiateTemplateFragment(FragmentComposite fragmentComposite)
    throws TemplateException
  {
    Objects.requireNonNull(fragmentComposite, "fragmentComposite must not be null");

    String templateId = TemplateEngine.getTemplateIdForFragment(fragmentComposite.getClass());
    String fragmentId = TemplateEngine.getFragmentId(fragmentComposite.getClass());

    return instantiateTemplateFragment(templateId, fragmentId, fragmentComposite);
  }

  /**
   * Builds the component tree based on the template fragment for the given template ID and fragment
   * ID.
   * <p>
   * Components are {@link #mapComponents(Object, ParsedTemplate) mapped} and
   * {@link #slotComponents(Object, ParsedTemplate) slotted} on the given fragment host.
   *
   * @param templateId
   *          the template ID
   * @param fragmentId
   *          the fragment ID
   * @param fragmentHost
   *          the host object (component or otherwise) that is used for the component mapping; the
   *          associated class loader may also be used to load the template document
   * @return the root component of the created component tree
   * @throws TemplateException
   *           if the template could not be successfully processed
   * @see #mapComponents(Object, ParsedTemplate)
   * @see #slotComponents(Object, ParsedTemplate)
   */
  public Component instantiateTemplateFragment(String templateId, String fragmentId,
      Object fragmentHost)
    throws TemplateException
  {
    Objects.requireNonNull(templateId, "templateId must not be null");

    Document document = getTemplateDocument(fragmentHost.getClass().getClassLoader(), templateId);

    Elements select = document.select("template#" + fragmentId);

    if (select.isEmpty())
      select = document.select("fragment#" + fragmentId);

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

  private Document getTemplateDocument(ClassLoader classLoader, String templateId)
  {
    Objects.requireNonNull(classLoader, "classLoader must not be null");
    Objects.requireNonNull(templateId, "templateId must not be null");

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
      document = templateCache.computeIfAbsent(templateId,
          tid -> resolveTemplateDocument(classLoader, tid));
    }
    else
    {
      document = resolveTemplateDocument(classLoader, templateId);
    }
    return document;
  }

  private Document resolveTemplateDocument(ClassLoader classLoader, String templateId)
  {
    if (resolvers == null || resolvers.isEmpty())
      throw new IllegalStateException("No TemplateResolvers registered.");

    Document document = null;
    for (TemplateResolver loader : resolvers)
    {
      document = loader.resolveTemplateDocument(classLoader, templateId).orElse(null);
      if (document != null)
        break;
    }

    if (document == null)
    {
      String msg = "No document found for template ID '%s'.";
      msg = String.format(msg, templateId);
      throw new TemplateException(msg);
    }

    return document;
  }


  /**
   * Maps components from the given {@link ParsedTemplate} to the {@link Mapped}-annotated fields of
   * the given host.
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

      if (!field.getType().isAssignableFrom(component.getClass()))
      {
        // try to implicitly wrap the component if matching constructor exists
        try
        {
          Constructor<?> constructor = field.getType().getConstructor(component.getClass());
          Object wrapper = constructor.newInstance(component);
          ReflectTools.setJavaFieldValue(host, field, wrapper);
          continue;
        }
        catch (NoSuchMethodException | SecurityException ex)
        {
          // no matching constructor found, ignore
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException
            | InvocationTargetException ex)
        {
          String msg =
              "Failed to wrap component with ID '%s' and type '%s' in an instance of type '%s'.";
          msg = String.format(msg, componentId, component.getClass().getName(),
              field.getType().getName());
          throw new TemplateException(msg, ex);
        }
      }

      ReflectTools.setJavaFieldValue(host, field, component);
    }
  }

  /**
   * Inserts components from the {@link Slotted}-annotated fields of the given host into the slots
   * of the {@link ParsedTemplate template}.
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

  private static String getTemplateId(Class<?> templateHostClass)
  {
    Optional<TemplateId> templateIdAtOpt =
        AnnotationReader.getAnnotationFor(templateHostClass, TemplateId.class);

    String templateId;
    if (templateIdAtOpt.isPresent())
      templateId = templateIdAtOpt.get().value();
    else
      templateId = templateHostClass.getName();

    return templateId;
  }

  private static String getTemplateIdForFragment(
      Class<? extends FragmentComposite> fragmentHostClass)
  {
    Class<?> clazz = fragmentHostClass;
    while (true)
    {
      if (TemplateComposite.class.isAssignableFrom(clazz))
      {
        return TemplateEngine.getTemplateId(clazz);
      }
      else
      {
        Optional<TemplateId> templateIdAtOpt =
            AnnotationReader.getAnnotationFor(clazz, TemplateId.class);
        if (templateIdAtOpt.isPresent())
        {
          return templateIdAtOpt.get().value();
        }
        else
        {
          Class<?> enclosingClass = clazz.getEnclosingClass();
          if (enclosingClass == null)
            return TemplateEngine.getTemplateId(clazz);

          clazz = enclosingClass;
        }
      }
    }
  }

  private static String getFragmentId(Class<? extends FragmentComposite> fragmentHostClass)
  {
    Optional<FragmentId> fragmentIdAtOpt =
        AnnotationReader.getAnnotationFor(fragmentHostClass, FragmentId.class);

    String fragmentId;
    if (fragmentIdAtOpt.isPresent())
      fragmentId = fragmentIdAtOpt.get().value();
    else
      fragmentId = fragmentHostClass.getSimpleName();

    return fragmentId;
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
