package com.jira.library.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.jira.library.book.model") // Spécifiez le package où se trouvent vos entités JPA
@SpringBootApplication(scanBasePackages = "com.jira.library")// Scanne tout le package de base com.jira.library	
@EnableJpaRepositories(basePackages = "com.jira.library.book.persistence") // Spécifiez le package où se trouvent vos repositories
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
