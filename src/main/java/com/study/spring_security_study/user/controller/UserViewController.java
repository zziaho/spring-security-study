package com.study.spring_security_study.user.controller;

import com.study.spring_security_study.user.dto.UserSignupDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

	/**
	 * 회원가입 화면으로 이동
	 */
	@GetMapping("/signUp")
	public String signUpView(Model model) {
		// 뷰에서 <form th:object="${user}">를 사용하기 위해 미리 바인딩
		model.addAttribute("user", new UserSignupDto());
		return "signup";
	}

}
