package com.coelhocaique.wallet.resource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coelhocaique.wallet.consts.Constants;
import com.coelhocaique.wallet.dto.WalletDTO;
import com.coelhocaique.wallet.exception.WalletException;
import com.coelhocaique.wallet.service.WalletService;

@RequestMapping("/v1")
@RestController
public class WalletResource {
	
	@Autowired
	private WalletService walletService;
	
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WalletDTO> create(@RequestBody @Valid WalletDTO walletDTO,
											@RequestHeader(value = Constants.AUTHORIZATION) String userKey) throws WalletException{
		
		walletDTO = walletService.create(walletDTO, userKey);
		
		return new ResponseEntity<WalletDTO>(walletDTO, HttpStatus.CREATED);
	}
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WalletDTO>> find(@RequestHeader(value = Constants.AUTHORIZATION) String userKey) throws WalletException{
		
		List<WalletDTO> walletDTOs = walletService.find(userKey);
		
		return new ResponseEntity<List<WalletDTO>>(walletDTOs,HttpStatus.OK);
	}
}
