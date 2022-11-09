package com.kgisl.san1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class San1Application {

	public static void main(String[] args) {
		SpringApplication.run(San1Application.class, args);
	}

}
