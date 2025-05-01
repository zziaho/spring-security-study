package com.study.spring_security_study.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSignupDto {

	private String userName;	// 사용자 이름
	private String password;	// 사용자 비밀번호
	private String email;		// 사용자 이메일

}
