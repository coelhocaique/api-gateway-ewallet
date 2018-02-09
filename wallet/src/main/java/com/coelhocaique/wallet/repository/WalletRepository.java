package com.coelhocaique.wallet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coelhocaique.wallet.model.Wallet;

public interface WalletRepository extends MongoRepository<Wallet, String>{
		
}
