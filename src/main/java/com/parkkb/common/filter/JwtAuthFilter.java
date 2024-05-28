package com.parkkb.common.filter;

import java.io.IOException;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkkb.common.enums.CustomErrorCode;
import com.parkkb.common.response.CustomErrorVo;
import com.parkkb.common.token.JwtProvider;

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

		if (isNotAuthentication()) {
			if (JwtProvider.validateToken(jwt)) {
				username = JwtProvider.parseToken(jwt).getSubject();
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(username, null, null); // 권한은 필요에 따라 설정 가능
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		chain.doFilter(request, response);

	}

	private static boolean isNotAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication() == null;
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

		response.getWriter()
				.write(Objects.requireNonNull(mapper.writeValueAsString(CustomErrorVo.toResponse(errorCode))));
	}

}
