package com.softwarefoundtion.helloworld;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchHelloWorldApplication.class, args);
	}

}
