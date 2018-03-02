package com.coelhocaique.wallet.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coelhocaique.wallet.consts.Constants;
import com.coelhocaique.wallet.dto.BaseDTO;
import com.coelhocaique.wallet.exception.WalletException;
import com.coelhocaique.wallet.feign.fallbacks.UserClientFallback;

@FeignClient(name="user",fallback = UserClientFallback.class)
public interface UserClient {
	
	@RequestMapping(value = "/v1/authenticate",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseDTO> authenticate(@RequestHeader(name = Constants.AUTHORIZATION) String key) throws WalletException;
}
