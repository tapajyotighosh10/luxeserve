package com.luxeserve.hotel_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI userServiceApi(){
        return new OpenAPI()
                .info(new Info().title("Hotel Service API")
                        .description("This is the REST API for Hotel Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Rating Service wiki")
                        .url("https://rating-service-dummy.com/docs"));
    }
}
