package com.cogent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin(origins="http://localhost:4200")
@Controller
public class MainController {
	@GetMapping
	public String test() {
		 System.out.println("Test");
		return "Test";
	}

}
