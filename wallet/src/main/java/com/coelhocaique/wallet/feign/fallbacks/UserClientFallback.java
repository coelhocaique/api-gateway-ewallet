package com.coelhocaique.wallet.feign.fallbacks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.coelhocaique.wallet.consts.Constants;
import com.coelhocaique.wallet.dto.BaseDTO;
import com.coelhocaique.wallet.exception.WalletException;
import com.coelhocaique.wallet.feign.UserClient;

@Component
public class UserClientFallback implements UserClient {

	@Override
	public ResponseEntity<BaseDTO> authenticate(String key) throws WalletException {
		HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<>(new BaseDTO(unauthorized.value(), Constants.SERVER_ERROR),unauthorized);
	}
}
