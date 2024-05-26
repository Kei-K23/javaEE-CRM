package dev.kei.web.service;

import java.util.List;

import dev.kei.web.entity.User;
import dev.kei.web.repository.UserRepository;

public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
}
