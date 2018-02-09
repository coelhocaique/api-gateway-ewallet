package com.coelhocaique.wallet.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WalletDTO extends BaseDTO {
	
	private String id;
	
	private String cardholder;
	
	private String cardNumber;
	
	private Integer expirationMonth;
	
	private Integer expirationYear;
	
	private Integer cvv;
	
	private String userKey;
	
	private Integer bin;
	
	private Integer last4;
	
	@Builder
	private WalletDTO(Integer code, String returnMessage) {
		super(code,returnMessage);
	}
	
	public WalletDTO setKey(String userKey){
		this.userKey = userKey;
		return this;		
	}
}
