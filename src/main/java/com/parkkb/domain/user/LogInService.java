package com.parkkb.domain.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.parkkb.common.enums.CustomErrorCode;
import com.parkkb.common.exception.CustomException;
import com.parkkb.infrastructure.user.UserService;
import com.parkkb.interfaces.user.request.LoginDto;
import com.parkkb.common.token.JwtProvider;
import com.parkkb.interfaces.user.response.LoginResultVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogInService {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final JwtProvider jwtProvider;

	public LoginResultVo login(LoginDto loginDto) {

		var myUser = userService.findByUserId(loginDto.userId());

		if (!myUser.isPresent()) {
			throw new CustomException(CustomErrorCode.NO_EXIST_USER);
		}

		var token = JwtProvider.generateToken(loginDto.userId());

		checkPassword(loginDto.password(), myUser.get().getPassword());

		userService.updateToken(token, myUser.get().getId());

		return LoginResultVo.builder()
				.resultCode(HttpStatus.OK.value())
				.resultMsg(HttpStatus.OK.name())
				.token(token)
				.build();

	}

	private void checkPassword(String password, String encryptedPassword) {
		if(!passwordEncoder.matches(password, encryptedPassword)){
			throw new CustomException(CustomErrorCode.NOT_MATCHE_PASSWORD);
		}
	}
}
