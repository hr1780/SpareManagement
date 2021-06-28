package com.cts.sparemanagement_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SparemanagementProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparemanagementProductApplication.class, args);
	}

}
