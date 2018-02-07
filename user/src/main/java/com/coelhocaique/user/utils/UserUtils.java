package com.coelhocaique.user.utils;

import org.springframework.security.crypto.codec.Base64;

import com.coelhocaique.user.model.User;

public class UserUtils {
	
	public static User generateKey(User user){
		String key = user.getId() + ":" + user.getUserName();
		key = encodeBase64(key);
		user.setKey(key);
		return user;
	}
	
	public static String encodeBase64(String content){
		return new String(Base64.encode(content.getBytes()));
	}
}
