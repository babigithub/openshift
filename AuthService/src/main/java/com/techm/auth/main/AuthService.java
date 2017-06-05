package com.techm.auth.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.techm.auth.*")
public class AuthService {

	public static void main(String[] args) {

		SpringApplication.run(AuthService.class, args);
		final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);
		String customlogger ="ADMS Loger::::";
		LOGGER.info(customlogger+"Online Shopping Cart Service Started....");

	}

}