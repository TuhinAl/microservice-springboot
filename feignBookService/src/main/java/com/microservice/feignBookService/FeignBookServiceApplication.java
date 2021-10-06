package com.microservice.feignBookService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FeignBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignBookServiceApplication.class, args);
	}

}
