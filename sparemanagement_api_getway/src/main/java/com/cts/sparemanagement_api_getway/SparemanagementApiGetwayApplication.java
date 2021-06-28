package com.cts.sparemanagement_api_getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SparemanagementApiGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparemanagementApiGetwayApplication.class, args);
	}

}
