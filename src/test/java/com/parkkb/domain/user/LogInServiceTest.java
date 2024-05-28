package com.parkkb.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.parkkb.infrastructure.user.UserService;
import com.parkkb.interfaces.user.enums.IdType;
import com.parkkb.interfaces.user.request.LoginDto;
import com.parkkb.interfaces.user.request.UserRegistrationDto;
import com.parkkb.interfaces.user.response.LoginResultVo;

@SpringBootTest
class LogInServiceTest {

	@Autowired
	private LogInService logInService;

	@Autowired
	private UserService userService;

	@Autowired
	private SignUpService signUpService;

	@DisplayName("정상적인 로그인 테스트")
	@Test
	void loginTest() {

		//given
		UserRegistrationDto userRegistrationDto = new UserRegistrationDto("abcd", "1234", "abc", IdType.REG_NO,
				"1231");
		signUpService.signUp(userRegistrationDto);

		LoginDto loginDto = new LoginDto("abcd", "1234");
		//when
		LoginResultVo loginResultVo = logInService.login(loginDto);

		//then
		Assertions.assertEquals(loginResultVo.getResultCode(), 200);
	}

}