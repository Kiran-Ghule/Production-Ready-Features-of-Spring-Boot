package com.week4.production_Ready.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
