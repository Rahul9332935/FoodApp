package com.foodwala.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
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
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer addressId;
  //@NotNull(message = "building name should not be null")
  private String buildingName;
  //@NotNull(message = "street Number should not be null")
  private Integer streetNo;
  
  //@NotNull(message = "area name should not be null")
 // @Size(min = 3,max = 12)
  private String area;
//  @NotNull(message = "city name should not be null")
//  @Size(min = 3,max = 12)
  private String city;
//  @NotNull(message = "state name should not be null")
//  @Size(min = 3,max = 12)
  private String state;
//  @NotNull(message = "country name should not be null")
//  @Size(min = 3,max = 12)
  private String country;
//  @NotNull(message = "pincode should not be null")
//  @Size(max = 6, min = 6)
  private String pincode;
  
  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  private Customer customer;
  
  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  private Restaurant restaurant;
  
  
  
  



  
	
	
	
}
