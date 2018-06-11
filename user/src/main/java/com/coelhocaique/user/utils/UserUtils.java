package com.coelhocaique.user.utils;

import java.util.Base64;

import org.springframework.http.HttpStatus;

import com.coelhocaique.user.consts.Constants;
import com.coelhocaique.user.exception.UserException;
import com.coelhocaique.user.model.User;

public class UserUtils {
	
	public static User generateKey(User user){
		String key = user.getId() + ":" + user.getUsername();
		user.setKey(encodeBase64(key));
		return user;
	}
	
	public static String encodeBase64(String content){
		return new String(Base64.getEncoder().encode(content.getBytes()));
	}
	
	public static String[] decodeKey(String key){
		String decodedKey = decodeBase64(key);
		return decodedKey.split(":");
	}
	
	public static String decodeBase64(String content){
		return new String(Base64.getDecoder().decode(content.getBytes()));
	}
	
	public static String[] getValidDecodedKey(String userKey) throws UserException{
		String[] decodedKey = decodeKey(userKey);
		
		if(decodedKey.length < 2){
			throw new UserException(HttpStatus.UNAUTHORIZED.value(), Constants.INVALID_KEY);
		}
		
		return decodedKey;
	}
}
