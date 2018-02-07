package com.coelhocaique.user.service;

import com.coelhocaique.user.dto.UserDTO;

public interface UserService {
	
	UserDTO create(UserDTO userDTO);
	
	UserDTO update(UserDTO userDTO);
	
	UserDTO delete(UserDTO userDTO);
	
	UserDTO find(String userName);

	UserDTO findById(String id);
}
