package com.coelhocaique.wallet.dto;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WalletDTO extends BaseDTO{
	
	private String id;
	
	@NotNull(message = "Username must be informed.")
	private String username;
	
	@Builder
	private WalletDTO(Integer code, String returnMessage) {
		super(code,returnMessage);
	}
}
