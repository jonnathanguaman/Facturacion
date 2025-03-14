package com.springcloud.store.spring_cloud_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientApplication.class, args);
	}

}
