package com.nttdata.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicePersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePersonApplication.class, args);
	}

}
