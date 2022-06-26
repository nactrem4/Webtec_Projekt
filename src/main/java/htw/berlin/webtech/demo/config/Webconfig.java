package htw.berlin.webtech.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    @EnableWebMvc
    public class Webconfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedMethods("*")
                    .allowedOrigins(
                            "http://localhost:3000",
                            "http://https://webtech-movie-frontend.herokuapp.com/"
                    );
        }
    }
