package com.parkkb.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.parkkb.infrastructure.user.UserRepository;
import com.parkkb.infrastructure.user.UserService;
import com.parkkb.interfaces.user.enums.IdType;
import com.parkkb.interfaces.user.request.UserRegistrationDto;

@SpringBootTest
class SignUpServiceTest {

	@Autowired
	UserService userService;

	@Autowired
	SignUpService signUpService;

	@MockBean
	UserRepository userRepository;

	@DisplayName("회원가입 SignUpService 테스트")
	@Test
	void signUpTest() {

		UserRegistrationDto userRegistrationDto = new UserRegistrationDto("abcd", "1234", "abc", IdType.REG_NO,
				"1231");

		Assertions.assertEquals(signUpService.signUp(userRegistrationDto).getResultCode(), 200);

	}
}