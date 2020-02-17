package de.codecamp.vaadin.flowdui.spring.autoconfigure;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import de.codecamp.vaadin.flowdui.TemplateBuilder.CacheMode;


/**
 * Configuration properties for {@link TemplateAutoConfiguration}.
 */
@Validated
@ConfigurationProperties(prefix = TemplateProperties.PREFIX)
public class TemplateProperties
{

  public static final String PREFIX = "codecamp.vaadin.dui";


  /**
   */
  @NotNull
  private CacheMode cacheMode = CacheMode.AUTO;


  public TemplateProperties()
  {
  }


  public CacheMode getCacheMode()
  {
    return cacheMode;
  }

  public void setCacheMode(CacheMode cacheMode)
  {
    this.cacheMode = cacheMode;
  }

}
