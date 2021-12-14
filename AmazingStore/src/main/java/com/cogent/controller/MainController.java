package com.cogent.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MainController {
	@GetMapping("/test")
	public String test() {
		 System.out.println("Test");
		return "Test";
	}

}
