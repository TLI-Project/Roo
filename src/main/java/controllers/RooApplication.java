package controllers;

import services.*;
import gateways.*;
import database.*;
import entities.*;
import interfaces.*;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Class with endpoints that frontend will call.
 */
@SpringBootApplication
@RestController
public class RooApplication {
	// Frameworks & Drivers
	private final CarAccessInterface carAccessInterface;

	// Use Case
	private final SvcCarDataProcess svcCarDataProcess;
	private final SvcCarToJsonRequestAdapter svcCarToJsonRequestAdapter;
	private final SvcCarMetaData svcCarMetaData;
	private final SvcCarDetails svcCarDetails;
	private final SvcCarDepreciation svcCarDepreciation;


	/**
	 * Following Dependency Injection.
	 */
	public RooApplication() {
		try {
			// Initialize the database
			Connection conn = DatabaseConnection.conn();
			InitDatabase.main(conn);
			conn.close();

			// Set Frameworks & Drivers
			carAccessInterface = new CarAccessSql();

			// Set Use Cases
			svcCarDataProcess = new SvcCarDataProcess();
			svcCarToJsonRequestAdapter = new SvcCarToJsonRequestAdapter();
			svcCarMetaData = new SvcCarMetaData();
			svcCarDetails = new SvcCarDetails();
			svcCarDepreciation = new SvcCarDepreciation();
	} catch (SQLException | IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "failed to initialize");
		}
	}

	/**
	 * Runs and initializes the backend.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RooApplication.class, args);
	}

	/**
	 * Request that asks for all the cars available.
	 * @return a list of all the car objects that contain their metadata.
	 */
	@PostMapping("/carMetaData")
	public HashMap<Integer, String> carMetaData() {
		return svcCarMetaData.getMetaData(svcCarDataProcess, svcCarToJsonRequestAdapter, carAccessInterface);
	}

	/**
	 * Get request that asks for a certain car by ID.
	 * @param id the ID of the car you are looking for.
	 * @return The car entity you are looking for.
	 */
	@PostMapping("/carDetails")
	public String carDetails(@RequestBody int id) {
		return svcCarDetails.getCarDetails(id, svcCarDataProcess, carAccessInterface, svcCarToJsonRequestAdapter);
	}

	/**
	 * Call the Senso API /rate endpoint with all the corresponding user information.
	 * @param inputData is the users finances and car information.
	 * @return json representation of the Senso API /rate calculation.
	 */
	@PostMapping(value = "/userCarLoan", consumes = "application/json", produces = "application/json")
	public String userCarLoan(@RequestBody GraphingData inputData) throws IOException, InterruptedException {
		return SvcSensoReadyInfo.userCarLoanRequest(inputData, carAccessInterface, svcCarDataProcess);
	}
	/**
	 * Get a given car's depreciation schedule over the next 10 years.
	 * @param id is the car whose depreciation you are looking for.
	 * @return an ArrayList representation of car depreciation (percent value) from year 1-10 respectively.
	 */
	@PostMapping("/carDepreciation")
	public String carDepreciation(@RequestBody int id) {
		return svcCarDepreciation.getCarDepreciation(id, svcCarDataProcess, carAccessInterface);
	}

	/**
	 * Fixes the cors issue that we were running into.
	 *
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
