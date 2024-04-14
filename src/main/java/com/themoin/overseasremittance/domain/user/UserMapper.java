package com.themoin.overseasremittance.domain.user;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;

import com.themoin.overseasremittance.common.context.EncryptionContext;
import com.themoin.overseasremittance.infrastructure.user.User;
import com.themoin.overseasremittance.interfaces.user.request.UserRegistrationDto;

@Mapper (componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "password", source = "password", qualifiedByName = "encryptPassword")
	@Mapping(target = "idValue", source = "idValue", qualifiedByName = "encryptIdValue")
	User toEntity(UserRegistrationDto dto, @Context EncryptionContext context);

	@Named("encryptPassword")
	static String encryptPassword(String password, @Context EncryptionContext context) {
		return context.getPasswordEncoder().encode(password);
	}

	@Named("encryptIdValue")
	static String encryptIdValue(String idValue, @Context EncryptionContext context) {
		TextEncryptor encryptor = Encryptors.text("password", context.getSalt());
		return encryptor.encrypt(idValue);
	}
}
