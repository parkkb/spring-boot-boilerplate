package com.themoin.overseasremittance.common.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {

	ALREADY_EXIST_USER(HttpStatus.BAD_REQUEST,"ERROR_USER_01", "동일한 사용자 아이디가 있습니다."),
	NO_EXIST_USER(HttpStatus.BAD_REQUEST, "ERROR_USER_02", "해당 아이디의 사용자가 없습니다."),
	NOT_MATCHE_PASSWORD(HttpStatus.BAD_REQUEST, "ERROR_USER_03", "비밀번호가 일차히자 않습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
