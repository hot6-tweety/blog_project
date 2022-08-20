package com.my.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {
	
	
	
	@GetMapping({"","/"})
	public String index() {
		
		return "index";
		
	}
	
	// USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

}