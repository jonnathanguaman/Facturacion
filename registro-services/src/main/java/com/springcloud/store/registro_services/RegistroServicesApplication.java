package com.springcloud.store.registro_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Hacemos que trabaje como eureka server
@EnableEurekaServer
@SpringBootApplication
public class  RegistroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroServicesApplication.class, args);
	}

}
