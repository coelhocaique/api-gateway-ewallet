package com.coelhocaique.wallet.validation;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import com.coelhocaique.wallet.consts.Constants;
import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.exception.WalletException;

public class WalletValidation {
	
	public static void validate(WalletDTO walletDTO) throws WalletException{
		isCreditCardExpired(walletDTO);
	}

	private static void isCreditCardExpired(WalletDTO walletDTO) throws WalletException {
		LocalDate currentDate = LocalDate.now();
		int month = currentDate.getMonthValue();
		int year = currentDate.getYear();
		int expireMonth = Integer.parseInt(walletDTO.getExpirationMonth());
		int expireYear = Integer.parseInt(walletDTO.getExpirationYear());
		
		if(expireYear > year || (expireYear == year && expireMonth > month)){
			throw new WalletException(HttpStatus.BAD_REQUEST.value(),Constants.CREDITCARD_EXPIRED);
		}
	}
}
