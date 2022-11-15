package com.foodwala.service;

import com.foodwala.exception.LoginException;
import com.foodwala.model.LoginDTO;

public interface LoginService {

	
	public String logIntoAccount(LoginDTO dto) throws LoginException;
	
	public String logOutFromAccount(String key) throws LoginException;
	
	
	
}
