package com.study.spring_security_study.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 (auto_increment)
	private Long id;

	@Column(nullable = false, unique = true) // null 값 들어갈 수 없음, 중복값 불가
	private String username; // 로그인 ID

	@Column(nullable = false) // null 값 들어갈 수 없음
	private String password; // 패스워드

}
