package com.parkkb.interfaces.user;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.parkkb.domain.user.LogInService;
import com.parkkb.infrastructure.user.UserService;
import com.parkkb.interfaces.user.request.LoginDto;
import com.parkkb.interfaces.user.response.LoginResultVo;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;

	@Mock
	private LogInService logInService;

	private MockMvc mockMvc;

	@Mock
	private UserService userService;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

		LoginDto loginDto = new LoginDto("abc@gmail.com", "dsfjsdf");
		given(logInService.login(loginDto)).willReturn(LoginResultVo.builder()
				.resultCode(200)
				.resultMsg("Success")
				.build());
	}

	@Test
	void loginTest() throws Exception {

		setup();
		LoginDto loginDto = new LoginDto("abc@gmail.com", "dsfjsdf");

		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(loginDto))
		);

		resultActions.andExpect(status().isOk());

	}

}