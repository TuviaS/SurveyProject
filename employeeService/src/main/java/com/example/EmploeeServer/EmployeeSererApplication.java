package com.example.EmploeeServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmployeeSererApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSererApplication.class, args);
	}

}
