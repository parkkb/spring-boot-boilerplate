package com.themoin.overseasremittance.domain.user;

import org.springframework.stereotype.Service;

import com.themoin.overseasremittance.infrastructure.user.UserService;
import com.themoin.overseasremittance.interfaces.user.request.LoginDto;
import com.themoin.overseasremittance.interfaces.user.response.LoginResultVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogInService {

	private final UserService userService;

	public LoginResultVo login(LoginDto loginDto) {
		return null;
	}
}
