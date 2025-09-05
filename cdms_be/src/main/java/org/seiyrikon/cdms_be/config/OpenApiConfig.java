package org.seiyrikon.cdms_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                    .info(new Info()
                            .title("CDMS API")
                            .description("Company Directory Management System REST API documentation with OpenAPI 3")
                            .version("1.0.0")
                            .contact(new Contact()
                                    .name("Seiyrikon")
                                    .email("devseiyrikon@gmail.com")
                                    .url("https://github.com/Seiyrikon"))
                            .license(new License()
                                    .name("CDMS 2.0")
                                    .url("https://cdms.org")));
    }
}
