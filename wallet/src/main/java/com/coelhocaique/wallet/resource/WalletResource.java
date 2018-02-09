package com.coelhocaique.wallet.resource;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.service.WalletService;

@RequestMapping("/v1")
@RestController
public class WalletResource {
	
	@Autowired
	private WalletService walletService;
	
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WalletDTO> create(@RequestBody @Valid WalletDTO walletDTO){
		
		return new ResponseEntity<WalletDTO>(walletDTO, HttpStatus.CREATED);
	}	
}
