package com.coelhocaique.wallet.utils;

import java.util.Base64;

public class WalletUtils {
	
	public static String[] decodeKey(String key){
		String decodedKey = decodeBase64(key);
		return decodedKey.split(":");
	}
	
	public static String decodeBase64(String content){
		return new String(Base64.getDecoder().decode(content.getBytes()));
	}
}
