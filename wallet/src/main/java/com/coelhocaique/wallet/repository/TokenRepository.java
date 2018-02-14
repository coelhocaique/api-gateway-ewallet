package com.coelhocaique.wallet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coelhocaique.wallet.model.Token;

public interface TokenRepository extends MongoRepository<Token, String>{
		
}
