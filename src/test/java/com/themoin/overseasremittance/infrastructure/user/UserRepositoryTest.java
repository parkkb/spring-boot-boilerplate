package com.themoin.overseasremittance.infrastructure.user;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.themoin.overseasremittance.interfaces.user.enums.IdType;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;



	@Test
	@DisplayName("회원가입 테스트")
	public void saveUser(){
		String userId = "abc@gmail.com";
		String password = "12345";
		String name = "김철수";
		String idType = IdType.REG_NO.name();
		String idValue = "090225";

		userRepository.save(User.builder()
						.userId(userId)
						.password(passwordEncoder.encode(password))
						.name(name)
						.idType(idType)
						.idValue(idValue)
				.build());

		List<User> userList = userRepository.findAll();

		User user = userList.get(0);

		assertThat(user.getUserId()).isEqualTo(userId);
		assertThat(user.getIdType()).isEqualTo(idType);

	}
}
