package org.gycoding.fallofthegods.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
    @Override
    @SuppressWarnings("null")
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("https://api.gateway.com", "http://localhost")
                .allowedMethods(HttpMethod.GET.name())
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}