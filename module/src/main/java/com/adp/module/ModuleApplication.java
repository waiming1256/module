package com.adp.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.adp.module.service.repository")
public class ModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApplication.class, args);
	}

}
