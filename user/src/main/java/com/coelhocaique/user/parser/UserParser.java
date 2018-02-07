package com.coelhocaique.user.parser;

import org.springframework.beans.BeanUtils;

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
			entity = new User();
			BeanUtils.copyProperties(entity, dto);
		}
		
		return dto;
	}
}
