package com.foodwala.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
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
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;
	private String restaurantName;
	
	
    
	@OneToOne(cascade =CascadeType.ALL)
	private Address address;
	

	@ManyToMany(cascade =CascadeType.ALL)
	private List<Item> itemList=new ArrayList<>();
	
	//@NotNull(message = "Enter manager name")
	private String managerName;
//	@NotNull(message = "enter contact number")
//	@Size(min = 10, message = "contact number should be 10 digit")
	private String contactNumber;
	
	//souvik added password
	private String password;

	
}
