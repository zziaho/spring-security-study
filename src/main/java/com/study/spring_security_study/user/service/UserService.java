package com.study.spring_security_study.user.service;

import com.study.spring_security_study.user.dto.UserSignupDto;
import com.study.spring_security_study.user.entity.User;
import com.study.spring_security_study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	/**
	 * 이메일(ID) 중복체크
	 */
	public boolean isEmailDuplicated(String email) {
		return userRepository.existsByEmail(email);
	}

	/**
	 * 회원가입
	 */
	public void signUp(UserSignupDto userSignupDto) {
		if (this.isEmailDuplicated(userSignupDto.getEmail())) {
			throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
		}

		// 패스워드 암호화
		String encodedPassword = passwordEncoder.encode(userSignupDto.getPassword());

		User user = User.createUser(
				userSignupDto.getUsername(),
				encodedPassword,
				userSignupDto.getEmail()
		);

		userRepository.save(user);
	}

}
