package dev.kei.web.service;

import java.util.List;

import dev.kei.web.entity.User;
import dev.kei.web.repository.UserRepository;

public class UserService {

	public List<User> findAll() {
		UserRepository userRepository = new UserRepository();
		return userRepository.findAll();
	}

	public User findByUsername(String username) {
		UserRepository userRepository = new UserRepository();
		return userRepository.findByUsername(username);
	}

	public void save(User user) {
		UserRepository userRepository = new UserRepository();
		userRepository.save(user);
	}
}