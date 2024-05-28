package com.parkkb.domain.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.parkkb.common.context.EncryptionContext;
import com.parkkb.common.enums.CustomErrorCode;
import com.parkkb.common.exception.CustomException;
import com.parkkb.common.response.ResultVo;
import com.parkkb.infrastructure.user.UserService;
import com.parkkb.interfaces.user.request.UserRegistrationDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpService {

	private final UserService userService;
	private final UserMapper userMapper;
	private final EncryptionContext encryptionContext;

	public ResultVo signUp(UserRegistrationDto userRegistrationDto) {
		if (ObjectUtils.isEmpty(userService.findByUserId(userRegistrationDto.userId()))) {
			userService.save(userMapper.toEntity(userRegistrationDto, encryptionContext));
			return ResultVo.builder()
					.resultCode(HttpStatus.OK.value())
					.resultMsg(HttpStatus.OK.name())
					.build();
		} else {
			throw new CustomException(CustomErrorCode.ALREADY_EXIST_USER);
		}

	}

	private String encryptIdValue(String idType, String idValue) {
		TextEncryptor encryptor = Encryptors.text("password", "5c0744940b5c369b");
		return encryptor.encrypt(idValue);
	}
}
