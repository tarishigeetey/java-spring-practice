package com.demo.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/getStudent")
	public String getStudent() {
		System.out.println("getStudent Called");
		return "fetch students";
	}
}
