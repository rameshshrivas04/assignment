package com.training.assignment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.assignment.domain.User;
import com.training.assignment.repository.UserRepository;
import com.training.assignment.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		if (null == user || user.getUsername().isEmpty()
				|| user.getPassword().isEmpty() || user.getRole().isEmpty()) {
			return null;
		}
		return userRepository.save(user);
	}

	@Override
	public User findOne(String userId) {

		if (userId.isEmpty()) {
			return null;
		}
		return userRepository.findOne(userId);
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();

	}
	
	@Override
	public void delete(User user) {

		  userRepository.delete(user);

	}

}
