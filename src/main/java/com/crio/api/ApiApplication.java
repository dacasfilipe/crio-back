package com.crio.api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.out.println("username:"+dotenv.get("DB_USERNAME"));
		System.out.println("password:"+dotenv.get("DB_PASSWORD"));
		SpringApplication.run(ApiApplication.class, args);
	}

}
