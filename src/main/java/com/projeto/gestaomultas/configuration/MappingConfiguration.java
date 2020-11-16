package com.projeto.gestaomultas.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfiguration {

  @Bean
  public ModelMapper ModelMapper() {
    return new ModelMapper();
  }

}
