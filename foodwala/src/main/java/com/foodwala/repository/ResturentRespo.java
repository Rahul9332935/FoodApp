package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwala.model.Customer;
import com.foodwala.model.Restaurant;

@Repository
public interface ResturentRespo extends JpaRepository<Restaurant, Integer>{
	
	public Restaurant findByContactNumber(String contactNumber);

}
