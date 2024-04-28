package com.parkkb.interfaces.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parkkb.interfaces.user.request.LoginDto;
import com.parkkb.domain.user.LogInService;
import com.parkkb.interfaces.user.response.LoginResultVo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {

	private final LogInService loginService;

	@GetMapping("/user/login")
	public LoginResultVo login(@Valid @RequestBody LoginDto loginDto){
		return loginService.login(loginDto);
	}

}
