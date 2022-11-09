package com.kgisl.sb2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition

public class Sb2Apllication {
    public static void main(String[] args) {
        SpringApplication.run(Sb2Apllication.class, args);
    }
}
