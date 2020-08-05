package com.node;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LinodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinodeApplication.class, args);
	}

}
