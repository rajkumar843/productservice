package com.mrk.springcloud.swagger;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI productSwaggerConfiguration() {
        return new OpenAPI()
                .info(new Info()
                        .title("Restaurant Microservice API")
                        .description("Restaurant Service APIs Documentation")
                        .version("1.0")
                        .contact(new Contact()
                                .name("MRK")
                                .email("mrk@gmail.com")));
    }
    }

