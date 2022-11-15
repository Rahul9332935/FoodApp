package com.foodwala.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.LoginException;
import com.foodwala.model.LoginDTO;
import com.foodwala.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> logIntoAccount( @Valid@RequestBody LoginDTO dto) throws LoginException{
		
		
    return new ResponseEntity<String>(loginService.logIntoAccount(dto),HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	
	
	@PostMapping("/logout/{key}")
	public ResponseEntity<String> logOutFromAccount(@PathVariable("key") String key) throws LoginException{
		
		
		 return new ResponseEntity<String>(loginService.logOutFromAccount(key),HttpStatus.ACCEPTED);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
