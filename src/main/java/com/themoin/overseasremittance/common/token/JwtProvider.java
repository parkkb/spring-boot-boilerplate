package com.themoin.overseasremittance.common.token;

import java.security.Key;
import java.util.Date;
import java.util.logging.Logger;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.themoin.overseasremittance.infrastructure.user.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtProvider{

	private static final Logger logger = Logger.getLogger(JwtProvider.class.getName());

	private final UserService userService;



	private static String secretKey;
	@Value("${security.jwt.key}")
	private static final String SECRET_KEY = "";

	private static SecretKey getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public static String generateToken(String username) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		long expMillis = nowMillis + 3600000; // 토큰의 유효 기간은 1시간으로 설정
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

	public static boolean validateToken(Claims claims) {
		try {
			return !claims.getExpiration().before(new Date());
		} catch (Exception ex) {
			return false;
		}
	}

}
