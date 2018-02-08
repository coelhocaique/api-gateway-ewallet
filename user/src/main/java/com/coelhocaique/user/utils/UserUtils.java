package com.coelhocaique.user.utils;

import org.springframework.security.crypto.codec.Base64;

import com.coelhocaique.user.model.User;

public class UserUtils {
	
	public static User generateKey(User user){
		String key = user.getId() + ":" + user.getUsername();
		user.setKey(encodeBase64(key));
		return user;
	}
	
	public static String encodeBase64(String content){
		return new String(Base64.encode(content.getBytes()));
	}
	
	public static String[] decodeKey(String key){
		String decodedKey = decodeBase64(key);
		return decodedKey.split(":");
	}
	
	public static String decodeBase64(String content){
		return new String(Base64.decode(content.getBytes()));
	}
}
