package com.themoin.overseasremittance.common.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {

	ALREADY_EXIST_USER(HttpStatus.BAD_REQUEST,"USER_01", "동일한 사용자 아이디가 있습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
