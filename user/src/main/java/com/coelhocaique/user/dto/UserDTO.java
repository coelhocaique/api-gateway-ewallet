package com.coelhocaique.user.dto;

import javax.validation.constraints.NotNull;

import com.coelhocaique.user.validation.Username;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	private String id;
	
	@NotNull
	@Username
	private String userName;
	
	private String key;
}
