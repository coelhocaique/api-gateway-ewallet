package com.coelhocaique.user.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.coelhocaique.user.service.UserService;

public class UsernameImpl implements ConstraintValidator<Username, String> {
	
	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(Username arg0) {
		
	}

	@Override
	public boolean isValid(String content, ConstraintValidatorContext arg1) {
		return userService.find(content) == null;
	}

}
