package com.themoin.overseasremittance.common.filter;

import java.io.IOException;
import java.security.SignatureException;
import java.util.Objects;

import javax.swing.undo.CannotUndoException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.themoin.overseasremittance.common.enums.CustomErrorCode;
import com.themoin.overseasremittance.common.exception.CustomException;
import com.themoin.overseasremittance.common.response.CustomErrorVo;
import com.themoin.overseasremittance.common.token.JwtProvider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		String username = null;
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
		}

		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			//Claims claims = JwtProvider.parseToken(jwt);
			if (JwtProvider.validateToken(jwt)) {
				username = JwtProvider.parseToken(jwt).getSubject();
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(username, null, null); // 권한은 필요에 따라 설정 가능
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		chain.doFilter(request, response);

	}

	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");

		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}

		return null;
	}

	public void setErrorResponse(HttpServletResponse response, CustomErrorCode errorCode) throws IOException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());

		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json; charset=utf-8");

		response.getWriter().write(Objects.requireNonNull(mapper.writeValueAsString(CustomErrorVo.toResponse(errorCode))));
	}

}
