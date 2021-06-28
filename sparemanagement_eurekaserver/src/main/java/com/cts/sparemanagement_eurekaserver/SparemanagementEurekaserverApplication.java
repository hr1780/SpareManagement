package com.cts.sparemanagement_eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SparemanagementEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparemanagementEurekaserverApplication.class, args);
	}

}
