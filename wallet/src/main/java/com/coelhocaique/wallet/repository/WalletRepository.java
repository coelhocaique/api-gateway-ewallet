package com.coelhocaique.wallet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coelhocaique.wallet.model.Wallet;

public interface WalletRepository extends MongoRepository<Wallet, String>{
	
	Optional<List<Wallet>> findByUserId(String userId);
	
	Optional<Wallet> findByIdAndUserId(String id,String userId);
}
