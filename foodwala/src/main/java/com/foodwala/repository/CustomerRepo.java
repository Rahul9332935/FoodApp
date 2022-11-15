package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwala.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	
	//souvik added password
	public Customer findByMobileNumber(String mobileNumber);
	
}
