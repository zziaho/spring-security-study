# 🛡️ Spring Security Study

스프링 시큐리티에 대한 내용을 학습하고 실습해보며 정리한 저장소입니다.  
인증(Authentication), 인가(Authorization), 커스텀 로그인, 실패 처리, 에러 핸들러 등  
실무에서 자주 쓰이는 보안 기능들을 직접 구현하며 학습했습니다.

> 💡 해당 프로젝트는 `Spring Boot + Spring Security + Thymeleaf` 기반으로 작성되었습니다.

---

## 🗂️ 프로젝트 구조
```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── study/
│   │           └── spring_security_study/
│   │               ├── config/
│   │               │   └── SecurityConfig.java                     # 시큐리티 설정
│   │               ├── controller/
│   │               │   ├── HomeController.java                     # 홈 & 로그인 화면
│   │               │   └── ErrorViewController.java                # 에러 페이지 매핑
│   │               └── handler/
│   │                   ├── CustomAuthenticationFailureHandler.java # 인증 실패 핸들러
│   │                   └── CustomAccessDeniedHandler.java          # 인가 실패 핸들러
│   └── resources/
│       ├── templates/
│       │   ├── login.html
│       │   ├── home.html
│       │   ├── user.html
│       │   ├── admin.html
│       │   └── error/
│       │       └── error_403.html
│       └── application.properties
```

## ✨ 구현 기능

### 🔐 인증 / 인가 (Authentication & Authorization)
- In-Memory 방식 사용자 인증
- 역할(Role)에 따른 접근 제어
- 로그인 성공 시 홈 화면으로 리다이렉트

### 💥 인증 실패 커스터마이징
- 로그인 실패 시 횟수 체크
- 3회 이상 실패 시 계정 잠금 처리
- `AuthenticationFailureHandler` 커스터마이징
- 로그인 실패 메시지 분기 (`locked`, `비밀번호 오류`)

### 🚫 인가 실패 커스터마이징
- `AccessDeniedHandler` 커스터마이징
- 권한 없는 사용자 접근 시 403 에러 페이지로 리다이렉트

### 🧾 로그 설정 (SLF4J + Logback)
- Spring Security 내부 필터 동작 로그 확인
- 컨트롤러 등 사용자 정의 로그 출력 설정

---

## 🧪 사용 기술 스택

| 분류 | 기술 |
|------|------|
| Language | Java 17 |
| Framework | Spring Boot 3.4.4 |
| Security | Spring Security |
| View | Thymeleaf |
| Build Tool | Gradle (Groovy) |

---

## 📝 블로그 포스팅
Spring Security 학습 내용을 정리한 블로그입니다👇

🔗 https://ziaho0403.tistory.com/