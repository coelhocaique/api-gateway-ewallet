package com.coelhocaique.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coelhocaique.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	boolean existsByUsername(String username);
	
	Optional<User> findByIdAndUsername(String id, String username);
}
