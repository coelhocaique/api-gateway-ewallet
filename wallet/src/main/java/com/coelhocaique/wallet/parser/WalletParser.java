package com.coelhocaique.wallet.parser;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.model.Wallet;

public class WalletParser {
	
	public static Wallet toEntity(WalletDTO dto){
		Wallet entity = null;
		
		if(dto != null){
			entity = new Wallet();
			BeanUtils.copyProperties(dto, entity);
		}
		
		return entity;
	}
	
	public static WalletDTO toDTO(Wallet entity){
		WalletDTO dto = null;
		
		if(entity != null){
			dto = new WalletDTO();
			BeanUtils.copyProperties(entity, dto);
		}
		
		return dto;
	}
	
	public static WalletDTO toDTO(HttpStatus statusCode, String message){
		return WalletDTO.builder()
				.code(statusCode.value())
				.returnMessage(message)
				.build();
	}
}
