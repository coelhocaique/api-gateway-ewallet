package com.coelhocaique.wallet.parser;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.model.Wallet;
import com.coelhocaique.wallet.utils.WalletUtils;

public class WalletParser {
	
	public static Wallet toEntity(WalletDTO dto){
		Wallet entity = null;
		
		if(dto != null){
			entity = new Wallet();
			BeanUtils.copyProperties(dto, entity);
			String cardNumber = dto.getCardNumber();
			String userKey = dto.getUserKey();
			entity.setBin(Integer.valueOf(cardNumber.substring(0,6)));
			entity.setLast4(Integer.valueOf(cardNumber.substring(7)));
			entity.setUserId(WalletUtils.decodeKey(userKey)[0]);
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
