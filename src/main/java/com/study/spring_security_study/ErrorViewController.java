package com.study.spring_security_study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/errorView")
@Controller
public class ErrorViewController {

	@GetMapping("/403")
	public String error403() {
		return "/error/error_403";
	}

}
