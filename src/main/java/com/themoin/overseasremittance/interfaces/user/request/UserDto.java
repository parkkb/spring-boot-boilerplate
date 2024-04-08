package com.themoin.overseasremittance.interfaces.user.request;


import com.themoin.overseasremittance.interfaces.user.enums.IdType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public record UserDto(
		@NotEmpty(message = "이메일 입력은 필수 입니다.")
		@Email
		String userId,
		@NotEmpty(message = "비밀번호 입력은 필수 입니다.")
		@Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
		String password,

		@NotEmpty(message = "이름 입력은 필수 입니다.")
		String name,
		IdType idType,
		String idValue
) {}
