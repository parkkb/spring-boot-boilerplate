package com.parkkb.common.response;

import org.springframework.http.ResponseEntity;

import com.parkkb.common.enums.CustomErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorVo {

	private int status;
	private String code;
	private String message;

	public static ResponseEntity<CustomErrorVo> toResponseEntity(CustomErrorCode e) {
		return ResponseEntity
				.status(e.getHttpStatus())
				.body(CustomErrorVo.builder()
						.code(e.getCode())
						.message(e.getMessage())
						.build());
	}

	public static CustomErrorVo toResponse(CustomErrorCode e) {
		return CustomErrorVo.builder()
				.code(e.getCode())
				.message(e.getMessage())
				.build();
	}
}
