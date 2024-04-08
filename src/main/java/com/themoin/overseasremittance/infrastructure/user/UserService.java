package com.themoin.overseasremittance.infrastructure.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void save(User user){
		userRepository.save(user);
	}

	public Optional<User> findByUserId(String userId){
		return userRepository.findByUserId(userId);
	}
}
