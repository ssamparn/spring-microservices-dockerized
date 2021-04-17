package com.containerize.dockerizediscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DockerizeDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerizeDiscoveryServiceApplication.class, args);
	}

}
