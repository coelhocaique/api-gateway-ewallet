package com.coelhocaique.wallet.service;

import com.coelhocaique.wallet.dto.TokenDTO;
import com.coelhocaique.wallet.exception.WalletException;

public interface TokenService {
		
	TokenDTO tokenize(String userKey,String walletId) throws WalletException;

	TokenDTO find(String walletId, String userKey) throws WalletException;

	TokenDTO delete(String walletId, String userKey) throws WalletException;
}
