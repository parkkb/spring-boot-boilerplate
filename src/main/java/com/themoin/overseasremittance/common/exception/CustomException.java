package com.themoin.overseasremittance.common.exception;

import com.themoin.overseasremittance.common.enums.CustomErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

	private final CustomErrorCode customErrorCode;
}
