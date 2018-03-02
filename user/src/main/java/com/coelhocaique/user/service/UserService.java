package com.coelhocaique.user.service;

import java.util.List;

import com.coelhocaique.user.dto.UserDTO;
import com.coelhocaique.user.exception.UserException;

public interface UserService {
	
	UserDTO create(UserDTO userDTO);
	
	UserDTO delete(String key) throws UserException;

	UserDTO find(String key) throws UserException;
	
	List<UserDTO> findAll() throws UserException;

	UserDTO authenticate(String key) throws UserException;
}
