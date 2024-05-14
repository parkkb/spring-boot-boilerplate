package com.parkkb.interfaces.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.parkkb.common.response.ResultVo;
import com.parkkb.infrastructure.user.User;
import com.parkkb.infrastructure.user.UserService;
import com.parkkb.interfaces.user.enums.IdType;
import com.parkkb.interfaces.user.request.UserRegistrationDto;
import org.mockito.BDDMockito;

@ExtendWith(MockitoExtension.class)
class SignUpControllerTest {

	@InjectMocks
	private SignUpController signUpController;

	@Mock
	private UserService userService;


	@DisplayName("회원가입 테스트")
	@Test
	public void signUpTest() {

		UserRegistrationDto userRegistrationDto = new UserRegistrationDto(
				"abc@gmail.com", "1234", "김철수", IdType.REG_NO, "219219003"
		);



		BDDMockito.given(signUpController.signUp(userRegistrationDto)).willReturn()
	}


}