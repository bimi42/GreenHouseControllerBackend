package com.imi.home.GreenHouseControllerBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.imi.home.GreenHouseControllerBackend")
@SpringBootApplication
public class GreenHouseControllerBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreenHouseControllerBackendApplication.class, args);
	}

}
