package com.coelhocaique.wallet.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.coelhocaique.wallet.consts.Constants;
import com.coelhocaique.wallet.dto.BaseDTO;
import com.coelhocaique.wallet.exception.WalletException;
import com.coelhocaique.wallet.feign.UserClient;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private UserClient userClient;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String userKey = request.getHeader(Constants.AUTHORIZATION);
		
		if(userKey == null){
			throw new WalletException(HttpStatus.BAD_REQUEST, Constants.HEADER_MISSING);
		}
		
		ResponseEntity<BaseDTO> authenticated = userClient.authenticate(userKey);
		
		if(authenticated.getStatusCode() != HttpStatus.OK){
			BaseDTO baseDTO = authenticated.getBody();
			throw new WalletException(HttpStatus.valueOf(baseDTO.getCode()),baseDTO.getReturnMessage());
		}
		
        return true;
    }
}
