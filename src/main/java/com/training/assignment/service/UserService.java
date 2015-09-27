package com.training.assignment.service;

 
import java.util.List;

import com.training.assignment.domain.User;

public interface UserService {

	public User saveUser(User user);
	public User findOne(String userId);
	public List<User> findAll();
	void delete(User user);
}
