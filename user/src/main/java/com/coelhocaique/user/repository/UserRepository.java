package com.coelhocaique.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coelhocaique.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
