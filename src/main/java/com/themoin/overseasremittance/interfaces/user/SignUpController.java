package com.themoin.overseasremittance.interfaces.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.themoin.overseasremittance.common.response.ResultVo;
import com.themoin.overseasremittance.domain.user.SignUpService;
import com.themoin.overseasremittance.interfaces.user.request.UserDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SignUpController {

	private final SignUpService signUpService;

	@PostMapping("/user/signup")
	public ResultVo signUp(@Valid @RequestBody UserDto userDto){
		return signUpService.signUp(userDto);
	}
}
