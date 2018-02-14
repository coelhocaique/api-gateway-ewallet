package com.coelhocaique.wallet.service;

import com.coelhocaique.wallet.dto.TokenDTO;

public interface TokenService {
	
	TokenDTO tokenize(String walletId);
	
}
