package com.coelhocaique.wallet.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coelhocaique.wallet.dto.BaseDTO;

@FeignClient("user")
public interface UserClient {
	
	@RequestMapping(value = "/v1/auth/{key}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseDTO> authenticate(@PathVariable("key") String key);
}