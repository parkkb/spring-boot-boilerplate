package com.parkkb.common.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.parkkb.common.exception.CustomException;
import com.parkkb.common.response.CustomErrorVo;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<CustomErrorVo> handleCustomException(final CustomException ex) {
		return CustomErrorVo.toResponseEntity(ex.getCustomErrorCode());
	}
}
