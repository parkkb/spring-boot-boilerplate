package com.parkkb.domain.user;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import com.parkkb.common.context.EncryptionContext;
import com.parkkb.infrastructure.user.User;
import com.parkkb.interfaces.user.request.UserRegistrationDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "password", source = "password", qualifiedByName = "encryptPassword")
	@Mapping(target = "idValue", source = "idValue", qualifiedByName = "encryptIdValue")
	@Mapping(target = "token", ignore = true)
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
