package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TryingSpring {

	@GetMapping("/Hello")
	public String home() {
	return "Hello Radhika ";
	
}
}
