package com.entryPass.visitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EntryPassVisitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntryPassVisitorApplication.class, args);
	}

}
