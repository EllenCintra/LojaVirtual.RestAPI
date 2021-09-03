package com.github.ericomonteiro.smartstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmartStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartStockApplication.class, args);
	}

}
