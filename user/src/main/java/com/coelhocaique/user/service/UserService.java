package com.coelhocaique.user.service;

import com.coelhocaique.user.dto.UserDTO;

public interface UserService {
	
	UserDTO create(UserDTO userDTO);
	
	UserDTO delete(String key);

	UserDTO find(String id);

	UserDTO authenticate(String key);
}
