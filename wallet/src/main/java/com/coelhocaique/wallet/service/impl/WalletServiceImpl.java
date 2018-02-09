package com.coelhocaique.wallet.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.exception.WalletException;
import com.coelhocaique.wallet.parser.WalletParser;
import com.coelhocaique.wallet.repository.WalletRepository;
import com.coelhocaique.wallet.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Override
	public WalletDTO create(WalletDTO walletDTO) throws WalletException {
		return Optional.ofNullable(walletDTO)
						.map(WalletParser::toEntity)
						.map(walletRepository::save)
						.map(WalletParser::toDTO)
						.get();
	}
	

}
