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
import com.coelhocaique.wallet.feign.UserClient;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private UserClient userClient;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String userKey = request.getHeader(Constants.AUTHORIZATION);
		
		if(userKey == null){
			return false;
		}
		
		ResponseEntity<BaseDTO> authenticated = userClient.authenticate(userKey);
		
        return authenticated.getStatusCode() == HttpStatus.OK;
    }
}
