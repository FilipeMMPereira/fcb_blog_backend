package com.fcb_blog_backend.fcb_blog_backend.spring.config.web;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Expõe a pasta uploads na raiz do projeto
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/"); // sem './' também funciona
    }
}
