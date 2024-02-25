package com.julio.projects.datahub.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Data Hub API",
                description = "API to assist with personal organization",
                contact = @Contact(
                        name = "Julio Cesar",
                        email = "contatojuliodeveloper@gmail.com"
                ),
                version = "v1"
        )
)
public class OpenApiConfig {
}
