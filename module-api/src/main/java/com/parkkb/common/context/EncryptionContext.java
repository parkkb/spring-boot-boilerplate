package com.parkkb.common.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptionContext {
	private final String salt;
	private final PasswordEncoder passwordEncoder;

	public EncryptionContext(@Value("${security.encryption.salt}") String salt, PasswordEncoder passwordEncoder) {
		this.salt = salt;
		this.passwordEncoder = passwordEncoder;
	}

	public String getSalt() {
		return salt;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
}
