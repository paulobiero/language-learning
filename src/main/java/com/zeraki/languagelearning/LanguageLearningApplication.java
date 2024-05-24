package com.zeraki.languagelearning;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LanguageLearningApplication {
//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE3MTY1MDg0NjcsImV4cCI6MTcxNjUyNjQ2N30.lhM1zDnk_XVfnN2Z9ZRFUBWAGERhz-cxE0hLTzM7vGvWR-_dN9Sm-wVJl33-WvHTYTd3C6GLJjS13-bRWhOY5g
	public static void main(String[] args) {
		SpringApplication.run(LanguageLearningApplication.class, args);
	}
	@Bean
	ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
