package com.digital.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ElectroluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectroluxApplication.class, args);
	}

}
