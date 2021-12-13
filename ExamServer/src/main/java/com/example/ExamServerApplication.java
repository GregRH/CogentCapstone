package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.UserService;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}
	@Override
	public void run(String ...args) throws Exception{
		System.out.println("Code started");
	}

}
