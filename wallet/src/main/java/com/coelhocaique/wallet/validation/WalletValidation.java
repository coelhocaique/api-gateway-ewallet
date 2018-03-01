package com.coelhocaique.wallet.validation;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import com.coelhocaique.wallet.consts.Constants;
import com.coelhocaique.wallet.dto.WalletRequestDTO;
import com.coelhocaique.wallet.exception.WalletException;

public class WalletValidation {
	
	public static void validate(WalletRequestDTO walletDTO) throws WalletException{
		isCreditCardExpired(walletDTO);
	}

	private static void isCreditCardExpired(WalletRequestDTO walletDTO) throws WalletException {
		LocalDate currentDate = LocalDate.now();
		int month = currentDate.getMonthValue();
		int year = Integer.parseInt(String.valueOf(currentDate.getYear()).substring(1));		
		int expireMonth = Integer.parseInt(walletDTO.getExpirationMonth());
		int expireYear = Integer.parseInt(walletDTO.getExpirationYear());
		
		if(expireYear < year || (expireYear == year && expireMonth < month)){
			throw new WalletException(HttpStatus.BAD_REQUEST,Constants.CREDITCARD_EXPIRED);
		}
	}
}
