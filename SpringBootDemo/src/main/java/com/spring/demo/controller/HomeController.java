package com.spring.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/print")
	public String printMessage(){
		
		return "Welcome"; 
	}
}
