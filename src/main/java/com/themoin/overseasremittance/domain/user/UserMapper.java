package com.themoin.overseasremittance.domain.user;

import org.mapstruct.Mapper;

import com.themoin.overseasremittance.infrastructure.user.User;
import com.themoin.overseasremittance.interfaces.user.request.UserDto;

@Mapper (componentModel = "spring")
public interface UserMapper {

	default User toUser(UserDto userDto, String encodedPassword){
		return User.builder()
				.userId(userDto.userId())
				.name(userDto.name())
				.password(encodedPassword)
				.idType(userDto.idType().name())
				.idValue(userDto.idValue())
				.build();
	}
}
