package com.study.spring_security_study.user.security;

import com.study.spring_security_study.user.entity.User;
import java.util.Collection;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

	private final User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
	}

	// 계정이 만료되지 않았는가?
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠기지 않았는가?
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는가?
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화 상태인가?
	@Override
	public boolean isEnabled() {
		return true;
	}

	// 암호화 된 패스워드
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	// 로그인 ID
	@Override
	public String getUsername() {
		return user.getEmail(); // 이메일을 로그인 ID로 사용
	}
}
