package com.containerize.dockerizecurrencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DockerizeCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerizeCurrencyConversionApplication.class, args);
	}

}
