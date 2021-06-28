package com.cts.sparemanagement_regestraion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SparemanagementRegestraionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparemanagementRegestraionApplication.class, args);
	}

}
