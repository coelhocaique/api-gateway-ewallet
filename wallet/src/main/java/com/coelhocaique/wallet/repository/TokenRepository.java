package com.coelhocaique.wallet.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coelhocaique.wallet.model.Token;

public interface TokenRepository extends MongoRepository<Token, String>{
	
	Optional<Token> findByWalletId(String walletId);
}