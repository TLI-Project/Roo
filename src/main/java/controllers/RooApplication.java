package controllers;

import database.DatabaseConnection;
import database.InitDatabase;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/** @SpringBootApplication marks configuration class that declares one or more Bean methods.
 * @Bean: see more @ https://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/ch02s02.html
 */
@SpringBootApplication
public class RooApplication {

	public static void main(String[] args) throws SQLException, IOException {

		Connection conn = DatabaseConnection.conn();
		InitDatabase.main(conn);
		conn.close();

		SpringApplication.run(RooApplication.class, args);


	}

	/**
	 * Fixes the cors issue that we were running into.
	 * @return WebMvcConfigurer
	 */
	@Bean // fix cors error
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NotNull CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
			}
		};
	}

}
