package com.coelhocaique.wallet.service.impl;

import java.util.Optional;

import org.apache.commons.codec.digest.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import com.coelhocaique.wallet.dto.TokenDTO;
import com.coelhocaique.wallet.model.Token;
import com.coelhocaique.wallet.parser.TokenParser;
import com.coelhocaique.wallet.repository.TokenRepository;
import com.coelhocaique.wallet.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
	
	@Autowired
	private TokenRepository tokenRepository;

	@Override
	public TokenDTO tokenize(String walletId) {
		
		Token token = Token.builder()
							.walletId(walletId)
							.build();
			
		token = tokenRepository.save(token);
		token.setToken(generateToken(token.getId()));
		token = tokenRepository.save(token);
		
		return TokenParser.toDTO(token);
	}

	private String generateToken(String tokenId) {
		return Optional.ofNullable(tokenId)
				.map(s -> Hex.encode(s.getBytes()).toString())
				.map(Crypt::crypt)
				.orElseThrow(RuntimeException::new);
	}

}
