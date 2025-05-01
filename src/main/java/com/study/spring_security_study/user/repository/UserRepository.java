package com.study.spring_security_study.user.repository;

import com.study.spring_security_study.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	// 기본 CRUD (save, findById, findAll 등) 자동 제공

	/**
	 * username으로 사용자 조회 메서드
	 * 이 메서드는 현재 사용하지 않으나 예시를 위해 생성한 메서드입니다.
	 */
	Optional<User> findByUserName(String userName);

	/**
	 * 이메일 중복 체크
	 */
	boolean existsByEmail(String email);

	/**
	 * 이메일로 사용자 조회
	 */
	User findByEmail(String email);

}
