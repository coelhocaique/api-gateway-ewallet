package com.coelhocaique.wallet.service;

import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.exception.WalletException;

public interface WalletService {
	
	WalletDTO create(WalletDTO walletDTO, String userKey) throws WalletException;
}
