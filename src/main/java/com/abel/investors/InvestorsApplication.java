package com.abel.investors;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvestorsApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));

		SpringApplication.run(InvestorsApplication.class, args);
	}

}
