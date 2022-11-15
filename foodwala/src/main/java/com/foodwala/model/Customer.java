package com.foodwala.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

//	@NotNull(message = "enter first name")
//	@Size(min = 3,max = 15)
	private String firstName;
  
//	@NotNull(message = "enter last name")
//	@Size(min = 3,max = 15)
	private String lastName;
	
//	@NotNull
//	@Size(min = 12, message ="enter the vaild age" )
	private Integer age;
  
	
	private String gender;
	
//	@NotNull
//	@Size(min = 10, message = "entre correct mobile number")
	private String mobileNumber;

	
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private FoodCart foodCart;
	

	//@Email(message = "email formate is not correct ")
	private String email;

	
	

	
}
