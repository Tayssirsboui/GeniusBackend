package tn.esprit.projet4arcticback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Autorise toutes les routes de l'API
                .allowedOrigins("http://localhost:4200") // Frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes autorisées
                .allowedHeaders("*") // Autoriser tous les headers
                .allowCredentials(true); // Autoriser les cookies si nécessaire
    }
}
