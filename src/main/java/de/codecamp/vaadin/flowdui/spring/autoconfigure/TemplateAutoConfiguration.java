package de.codecamp.vaadin.flowdui.spring.autoconfigure;

import java.util.List;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateResolver;
import de.codecamp.vaadin.flowdui.TemplateEngine;


@Configuration
@EnableConfigurationProperties(TemplateProperties.class)
public class TemplateAutoConfiguration
{

  private TemplateProperties properties;


  public TemplateAutoConfiguration(TemplateProperties properties)
  {
    this.properties = properties;
  }


  @Bean
  public TemplateEngine vaadinTemplateBuilder(List<ComponentFactory> additionalFactories,
      List<ComponentPostProcessor> additionalPostProcessors,
      List<TemplateResolver> additionalResolvers)
  {
    TemplateEngine bean = new TemplateEngine(additionalFactories,
        additionalPostProcessors, additionalResolvers);
    bean.setCacheMode(properties.getCacheMode());
    return bean;
  }

}
