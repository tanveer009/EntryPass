package com.entryPass.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EntryPassUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntryPassUiApplication.class, args);
	}

}
