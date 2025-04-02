package com.study.spring_security_study.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);
	private final Map<String, Integer> failCounts = new HashMap<>();
	private final int MAX_FAIL_COUNT = 3;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String username = request.getParameter("username");

		int newFailCount = failCounts.getOrDefault(username, 0) + 1;
		failCounts.put(username, newFailCount);

		log.warn("로그인 실패 - 사용자: {}, 실패 횟수: {}", username, newFailCount);

		if (newFailCount >= MAX_FAIL_COUNT) {
			log.error("계정 잠금처리: {}", username);
			response.sendRedirect("/login?error=locked");
		} else {
			response.sendRedirect("/login?error=true");
		}

	}

}
