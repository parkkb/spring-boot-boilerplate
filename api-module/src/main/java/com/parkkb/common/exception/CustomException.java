package com.parkkb.common.exception;

import com.parkkb.common.enums.CustomErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

	private final CustomErrorCode customErrorCode;
}
