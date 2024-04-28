package com.parkkb.common.token;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtProvider{

	private static String secretKey;
	private static long expirationMs;

	@Value("${security.jwt.key}")
	public void setSecretKey(String secretKey){
		JwtProvider.secretKey = secretKey;
	}

	@Value("${security.jwt.expirationMs}")
	public void setExpirationMs(long expirationMs){
		JwtProvider.expirationMs = expirationMs;
	}

	private static SecretKey getSigningKey() {

		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public static String generateToken(String username) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		long expMillis = nowMillis + expirationMs; // 토큰의 유효 기간은 1시간으로 설정
		Date exp = new Date(expMillis);

		return Jwts.builder()
				.subject(username)
				.issuedAt(now)
				.expiration(exp)
				.signWith(getSigningKey())
				.compact();
	}

	public static Claims parseToken(String jwt) {
		return Jwts.parser()
				.verifyWith(getSigningKey())
				.build()
				.parseSignedClaims(jwt)
				.getPayload();
	}

	public static boolean validateToken(String token) {
		try {
			return !parseToken(token).getExpiration().before(new Date());
		} catch (Exception ex) {
			return false;
		}
	}

}
