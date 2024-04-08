package com.themoin.overseasremittance.domain.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.themoin.overseasremittance.common.enums.CustomErrorCode;
import com.themoin.overseasremittance.common.exception.CustomException;
import com.themoin.overseasremittance.common.response.ResultVo;
import com.themoin.overseasremittance.infrastructure.user.UserService;
import com.themoin.overseasremittance.interfaces.user.request.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpService {

	private final UserService userService;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	public ResultVo signUp(UserDto userDto){
		if(ObjectUtils.isEmpty(userService.findByUserId(userDto.userId()))){
			userService.save(userMapper.toUser(userDto,passwordEncoder.encode(userDto.password())));
			return ResultVo.builder()
					.resultCode(HttpStatus.OK.value())
					.resultMsg(HttpStatus.OK.name())
					.build();
		}
		else{
			throw new CustomException(CustomErrorCode.ALREADY_EXIST_USER);
		}

	}
}
