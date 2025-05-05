package com.study.spring_security_study.user.security;

import com.study.spring_security_study.user.entity.User;
import com.study.spring_security_study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// email(로그인ID)를 기반으로 DB에서 사용자정보 조회 → 없으면 예외 발생
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다." + email));

		return new CustomUserDetails(user);
	}
}
