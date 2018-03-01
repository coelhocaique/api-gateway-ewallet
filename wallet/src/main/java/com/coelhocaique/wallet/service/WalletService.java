package com.coelhocaique.wallet.service;

import java.util.List;

import com.coelhocaique.wallet.dto.WalletRequestDTO;
import com.coelhocaique.wallet.dto.WalletResponseDTO;
import com.coelhocaique.wallet.exception.WalletException;

public interface WalletService {
	
	WalletResponseDTO create(WalletRequestDTO walletDTO, String userKey) throws WalletException;
	
	WalletResponseDTO find(String id, String userKey) throws WalletException;
	
	List<WalletResponseDTO> find(String userKey) throws WalletException;
	
	WalletResponseDTO delete(String id, String userKey) throws WalletException;
}
