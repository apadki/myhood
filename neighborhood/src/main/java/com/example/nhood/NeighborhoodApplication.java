package com.example.nhood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

/*@EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
@ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
@Configuration: allow to register extra beans in the context or import additional configuration classes
*/public class NeighborhoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeighborhoodApplication.class, args);
	}

}
