package com.coelhocaique.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.coelhocaique.user.consts.Constants;
import com.coelhocaique.user.dto.UserDTO;
import com.coelhocaique.user.model.User;
import com.coelhocaique.user.parser.UserParser;
import com.coelhocaique.user.repository.UserRepository;
import com.coelhocaique.user.service.UserService;
import com.coelhocaique.user.utils.UserUtils;

import lombok.Setter;

@Service
public class UserServiceImpl implements UserService {
	
	@Setter
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
	public UserDTO delete(String key) {
		String[] decodedKey = UserUtils.decodeKey(key);
		Optional<User> user = userRepository.findByIdAndUsername(decodedKey[0], decodedKey[1]);
											
		user.ifPresent(userRepository::delete);
							  
		return user.map(UserParser::toDTO)
					.orElse(UserParser.toDTO(HttpStatus.NO_CONTENT, Constants.USER_NOT_FOUND));
	}

	@Override
	public UserDTO find(String id) {
		return Optional.ofNullable(userRepository.findOne(id))
						.map(UserParser::toDTO)
						.orElse(UserParser.toDTO(HttpStatus.NO_CONTENT, Constants.USER_NOT_FOUND));
	}

	@Override
	public UserDTO authenticate(String key) {
		String[] decodedKey = UserUtils.decodeKey(key);
		
		if(decodedKey.length < 1){
			return UserParser.toDTO(HttpStatus.UNAUTHORIZED, Constants.INVALID_KEY);
		}
		
		return userRepository.findByIdAndUsername(decodedKey[0], decodedKey[1])
							.map(UserParser::toDTO)
							.orElse(UserParser.toDTO(HttpStatus.UNAUTHORIZED, Constants.INVALID_KEY));
	}

}
