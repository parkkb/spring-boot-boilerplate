package com.parkkb.interfaces.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parkkb.common.response.ResultVo;
import com.parkkb.domain.user.SignUpService;
import com.parkkb.interfaces.user.request.UserRegistrationDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SignUpController {

	private final SignUpService signUpService;

	@PostMapping("/user/signup")
	public ResultVo signUp(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
		return signUpService.signUp(userRegistrationDto);
	}

}
