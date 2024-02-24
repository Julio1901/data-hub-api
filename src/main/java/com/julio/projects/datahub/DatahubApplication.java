package com.julio.projects.datahub;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Data Hub API", version = "1", description = "API to assist with personal organization"))
public class DatahubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatahubApplication.class, args);
	}

}
