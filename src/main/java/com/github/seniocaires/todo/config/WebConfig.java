package com.github.seniocaires.todo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //
        .allowedOriginPatterns("http://localhost:4200", "https://seniocaires.github.io/") //
        .allowedMethods("POST", "GET", "PUT", "DELETE", "PATCH", "OPTIONS");// <- assim permite de qualquer origem, troque "/**" pelo seu dominio por exemplo "http://meudominio.com"
    }
}
