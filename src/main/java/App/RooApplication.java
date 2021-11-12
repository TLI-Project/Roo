package App;

import Database.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** @SpringBootApplication marks configuration class that declares one or more Bean methods.
 * @Bean: see more @ https://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/ch02s02.html
 */
@SpringBootApplication
public class RooApplication {

	public static void main(String[] args) {
		Database db = new Database();
		db.createDatabase();

		SpringApplication.run(RooApplication.class, args);
	}

	/**
	 * Fixes the cors issue that we were running into.
	 * @return WebMvcConfigurer
	 * TODO not sure how this method works but it does it's job. Look into it and document better.
	 */
	@Bean // fix cors error
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
			}
		};
	}

}
