package com.parkkb.infrastructure.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}

	public Optional<User> findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

	@Transactional
	public void updateToken(String token, Long id) {
		Optional<User> user = userRepository.findById(id);
		user.ifPresent(value -> value.setToken(token));
	}

	public User findById(long l) {
		return userRepository.findById(l).orElse(null);
	}
}
