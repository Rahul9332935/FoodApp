package com.foodwala.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginDTO {

	//@Size(min=10,max=12,message = "Enter valid mobile number.")
	private String mobileNo;
	
	//@Size(min=4,max=10, message = "Password length should be 4 to 10")
	private String password;
	
	
	@NotNull(message = "Please select the User type")
	private String userType;
	
	
	
}
