package com.coelhocaique.wallet.service;

import java.util.List;

import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.exception.WalletException;

public interface WalletService {
	
	WalletDTO create(WalletDTO walletDTO, String userKey) throws WalletException;

	List<WalletDTO> find(String userKey);
}
