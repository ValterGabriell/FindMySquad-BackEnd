package com.example.microservico.Microservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoApplication.class, args);
	}

}
