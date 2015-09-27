package com.training.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.assignment.domain.User;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, String> {

	
}
