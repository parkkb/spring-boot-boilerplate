package com.themoin.overseasremittance.common.filter;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.themoin.overseasremittance.common.enums.CustomErrorCode;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private final JwtAuthFilter jwtAuthFilter;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
						 AuthenticationException authException) throws IOException {
		jwtAuthFilter.setErrorResponse(response, CustomErrorCode.NOT_VALIDATE_JWT_TOKEN);
	}
}
