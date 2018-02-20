package com.coelhocaique.wallet.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coelhocaique.wallet.dto.TokenDTO;
import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.exception.WalletException;
import com.coelhocaique.wallet.model.Wallet;
import com.coelhocaique.wallet.parser.WalletParser;
import com.coelhocaique.wallet.repository.WalletRepository;
import com.coelhocaique.wallet.service.TokenService;
import com.coelhocaique.wallet.service.WalletService;
import com.coelhocaique.wallet.validation.WalletValidation;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private TokenService tokenService;
	

	@Override
	public WalletDTO create(WalletDTO walletDTO, String userKey) throws WalletException{
		WalletValidation.validate(walletDTO);
		
		boolean tokenize = walletDTO.isTokenize();
		
		walletDTO = Optional.ofNullable(walletDTO)
							.map(e -> WalletParser.toEntity(e, userKey))
							.map(walletRepository::save)
							.map(WalletParser::toDTO)
							.get();
		
		if(tokenize){
			TokenDTO tokenDTO = tokenService.tokenize(walletDTO.getId());
			Wallet wallet = walletRepository.findOne(walletDTO.getId());
			wallet.setTokenized(tokenize);
			walletRepository.save(wallet);
			walletDTO.setToken(tokenDTO.getToken());
			
		}
		
		return walletDTO;
	}
}
