package com.study.spring_security_study.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "users")
@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 (auto_increment)
	private Long id;

	@Column(nullable = false, unique = true) // null 값 들어갈 수 없음, 중복값 불가
	private String userName; // 사용자 이름

	@Column(nullable = false) // null 값 들어갈 수 없음
	private String password; // 사용자 패스워드

	@Column(nullable = false, unique = true)
	private String email; // 이메일 및 로그인용 ID값

	// 권한 정보 (ex: ROLE_USER, ROLE_ADMIN)
	private String role = "ROLE_USER";

	// 기본 생성자
	protected User() {};

	// 정적 팩토리 메서드 방식으로 객체 생성 
	public static User createUser(String userName, String password, String email) {
		User user = new User();
		user.userName = userName;
		user.password = password;
		user.email = email;
		user.role = "ROLE_USER";
		return user;
	}
}