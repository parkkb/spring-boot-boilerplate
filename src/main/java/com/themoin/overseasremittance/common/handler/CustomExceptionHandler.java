package com.themoin.overseasremittance.common.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.themoin.overseasremittance.common.exception.CustomException;
import com.themoin.overseasremittance.common.response.CustomErrorVo;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<CustomErrorVo> handleCustomException(final CustomException ex){
		return CustomErrorVo.toResponseEntity(ex.getCustomErrorCode());
	}
}
