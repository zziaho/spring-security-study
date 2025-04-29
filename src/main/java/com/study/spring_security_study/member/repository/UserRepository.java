package com.study.spring_security_study.member.repository;

import com.study.spring_security_study.member.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	// 기본 CRUD (save, findById, findAll 등) 자동 제공

	/**
	 * username으로 사용자 조회 메서드
	 */
	Optional<User> findByUsername(String username);

}
