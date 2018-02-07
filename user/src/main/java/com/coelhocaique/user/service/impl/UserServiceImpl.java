package com.coelhocaique.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coelhocaique.user.dto.UserDTO;
import com.coelhocaique.user.model.User;
import com.coelhocaique.user.parser.UserParser;
import com.coelhocaique.user.repository.UserRepository;
import com.coelhocaique.user.service.UserService;
import com.coelhocaique.user.utils.UserUtils;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO create(UserDTO userDTO) {
		return Optional.ofNullable(userDTO)
						.map(UserParser::toEntity)
						.map(userRepository::save)
						.map(UserUtils::generateKey)
						.map(userRepository::save)
						.map(UserParser::toDTO)
						.get();
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO delete(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findById(String id) {
		Optional.ofNullable(userRepository.findOne(id))
				.map(UserParser::toDTO);
				
		return null;
	}

	@Override
	public UserDTO find(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
