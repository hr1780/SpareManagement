package com.cts.sparemanagement_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SparemanagementOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparemanagementOrderApplication.class, args);
	}

}
