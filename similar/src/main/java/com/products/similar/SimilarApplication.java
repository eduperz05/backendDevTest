package com.products.similar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimilarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimilarApplication.class, args);
	}

}
