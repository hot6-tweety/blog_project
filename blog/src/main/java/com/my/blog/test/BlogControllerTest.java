package com.my.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
	
	// http://localhost:8090/test/hello
	@GetMapping("/test/hello")
	public String hello() {
		return"<h1> hello Blog Project</h1>";
	}
} 
