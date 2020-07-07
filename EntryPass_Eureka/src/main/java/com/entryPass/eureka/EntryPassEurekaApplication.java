package com.entryPass.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EntryPassEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntryPassEurekaApplication.class, args);
	}

}
