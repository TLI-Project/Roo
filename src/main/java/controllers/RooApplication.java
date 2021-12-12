package controllers;

import gateways.DatabaseConnection;
import Database.InitDatabase;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Centralized application
 */
@SpringBootApplication
public class RooApplication {

	/**
	 * Runs and initializes the backend.
	 * @param args the input
	 */
	public static void main(String[] args) throws SQLException, IOException {

		// initialize the database
		Connection conn = DatabaseConnection.conn();
		InitDatabase.main(conn);
		conn.close();

		// run the main application
		SpringApplication.run(RooApplication.class, args);
	}

	/**
	 * Fixes the cors issue that we were running into.
	 * @return WebMvcConfigurer
	 */
	@Bean
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
