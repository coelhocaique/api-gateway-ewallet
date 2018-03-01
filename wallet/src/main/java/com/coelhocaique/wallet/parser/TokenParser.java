package com.coelhocaique.wallet.parser;

import org.springframework.beans.BeanUtils;

import com.coelhocaique.wallet.dto.TokenDTO;
import com.coelhocaique.wallet.model.Token;

public class TokenParser {
	
	public static TokenDTO toDTO(Token entity){
		TokenDTO dto = null;
		
		if(entity != null){
			dto = new TokenDTO();
			BeanUtils.copyProperties(entity, dto);
		}
		
		return dto;
	}
	
	public static Token toEntity(String walletId){
		return Token.builder()
					.walletId(walletId)
					.build();
	}
}
