package com.parkkb.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.parkkb.interfaces.user.request.LoginDto;

@SpringBootTest
class LogInServiceTest {

	@MockBean
	private LogInService logInService;

	@DisplayName("정상적인 로그인 테스트")
	@Test
	void loginTest() {


		//given
		LoginDto loginDto = new LoginDto("abcd", "1234");
		//when
		logInService.login(loginDto);

		//then
		Mockito.verify(logInService).login(loginDto);
	}

}