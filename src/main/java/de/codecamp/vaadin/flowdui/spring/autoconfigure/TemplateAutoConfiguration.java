package de.codecamp.vaadin.flowdui.spring.autoconfigure;

import java.util.List;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.codecamp.vaadin.flowdui.ComponentFactory;
import de.codecamp.vaadin.flowdui.ComponentPostProcessor;
import de.codecamp.vaadin.flowdui.TemplateBuilder;


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
  public TemplateBuilder vaadinTemplateBuilder(List<ComponentFactory> additionalFactories,
      List<ComponentPostProcessor> additionalPostProcessors)
  {
    TemplateBuilder bean = new TemplateBuilder(additionalFactories, additionalPostProcessors);
    bean.setCacheMode(properties.getCacheMode());
    return bean;
  }

}
