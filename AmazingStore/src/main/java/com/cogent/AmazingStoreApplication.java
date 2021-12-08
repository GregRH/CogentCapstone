package com.cogent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cogent.controller.RestControl;

@SpringBootApplication
public class AmazingStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazingStoreApplication.class, args);
	}

}
