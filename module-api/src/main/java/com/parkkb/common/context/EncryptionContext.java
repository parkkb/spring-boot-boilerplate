package com.parkkb.common.context;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Getter
@Component
public class EncryptionContext {
	private final String salt;
	private final PasswordEncoder passwordEncoder;

	public EncryptionContext(@Value("${security.encryption.salt}") String salt, PasswordEncoder passwordEncoder) {
		this.salt = salt;
		this.passwordEncoder = passwordEncoder;
	}

}
