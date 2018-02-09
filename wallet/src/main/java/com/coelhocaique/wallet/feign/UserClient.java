package com.coelhocaique.wallet.feign;

import javax.ws.rs.Produces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coelhocaique.wallet.dto.BaseDTO;

@FeignClient("user")
public interface UserClient {
	
	@GetMapping("/auth/{key}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseDTO> authenticate(@PathVariable("key") String key);
}
