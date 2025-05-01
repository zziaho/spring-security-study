package com.study.spring_security_study.user.controller;

import com.study.spring_security_study.user.dto.UserSignupDto;
import com.study.spring_security_study.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

	private final UserService userService;

	/**
	 * 회원가입
	 */
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute("user") UserSignupDto userSignupDto, Model model) {
		try {
			userService.signUp(userSignupDto);
			return "redirect:/login";
		} catch (IllegalArgumentException e) {
			model.addAttribute("error", e.getMessage());
			return "signup";
		}
	}

}
