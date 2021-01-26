package com.gaz.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@ComponentScan(basePackages = "com.gaz.web")
@EnableWebMvc
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Value("${prefixViewRes}")
    private String prefixViewRes;

    @Value("${suffixViewRes}")
    private String suffixViewRes;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix(prefixViewRes);
        internalResourceViewResolver.setSuffix(suffixViewRes);
        return internalResourceViewResolver;
    }
}
