package com.coelhocaique.user.parser;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import com.coelhocaique.user.dto.UserDTO;
import com.coelhocaique.user.model.User;

public class UserParser {
	
	public static User toEntity(UserDTO dto){
		User entity = null;
		
		if(dto != null){
			entity = new User();
			BeanUtils.copyProperties(dto, entity);
		}
		
		return entity;
	}
	
	public static UserDTO toDTO(User entity){
		UserDTO dto = null;
		
		if(entity != null){
			dto = new UserDTO();
			BeanUtils.copyProperties(entity, dto);
		}
		
		return dto;
	}
	
	public static UserDTO toDTO(HttpStatus statusCode, String message){
		return UserDTO.builder()
				.code(statusCode.value())
				.returnMessage(message)
				.build();
	}
}
