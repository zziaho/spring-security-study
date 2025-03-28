package com.study.spring_security_study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/homeView")
	public String homeView() {
		return "home";
	}

	@GetMapping("/userView")
	public String userView() {
		return "user";
	}

	@GetMapping("/adminView")
	public String adminView() {
		return "admin";
	}

}
