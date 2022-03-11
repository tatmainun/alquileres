package com.cundatat.alquileres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.cundatat.alquileres.modelos")
@SpringBootApplication
public class AlquileresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlquileresApplication.class, args);
	}

}
