package com.study.spring_security_study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(HomeController.class);

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

	@GetMapping("/login")
	public String loginView() {
		log.debug("로그인 화면 호출");
		return "login";
	}

}
