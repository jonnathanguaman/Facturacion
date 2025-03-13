package com.springcloud.store.spring_cloud_factura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudFacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFacturaApplication.class, args);
	}

}
