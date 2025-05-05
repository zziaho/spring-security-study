package com.study.spring_security_study;

import com.study.spring_security_study.handler.CustomAccessDeniedHandler;
import com.study.spring_security_study.handler.CustomAuthenticationFailureHandler;
import com.study.spring_security_study.user.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	private final CustomUserDetailsService customUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * DB 사용으로 In-Memory 방식 제거
	 */
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//		UserDetails user = User.builder()
//				.username("user")
//				.password(passwordEncoder.encode("user1234"))
//				.roles("USER")
//				.build();
//
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(passwordEncoder.encode("admin1234"))
//				.roles("ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/adminView").hasRole("ADMIN")
						.requestMatchers("/userView").hasRole("USER")
						.requestMatchers("/", "/homeView").authenticated()
						.requestMatchers("/h2-console/**").permitAll() // <-- 추가
						.anyRequest().permitAll()
				)
				.csrf(csrf -> csrf
						.ignoringRequestMatchers("/h2-console/**") // <-- CSRF 예외도 추가
				)
				.headers(headers -> headers
						.frameOptions(frame -> frame.sameOrigin()) // <-- H2 콘솔은 iframe을 쓰니까 이것도 허용
				)
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login") // 생략해도 default값 "/login"
						.usernameParameter("email") // email을 로그인 ID로 사용
						.defaultSuccessUrl("/homeView", true)
						.failureHandler(new CustomAuthenticationFailureHandler())
						.permitAll()
				)
				.userDetailsService(customUserDetailsService)
				.logout(logout -> logout.permitAll())
				.exceptionHandling(exception ->
						exception.accessDeniedHandler(new CustomAccessDeniedHandler()));

		return http.build();
	}

}
