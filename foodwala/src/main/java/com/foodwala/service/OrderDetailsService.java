package com.foodwala.service;

import java.util.List;


import com.foodwala.exception.CustomerException;
import com.foodwala.exception.OrderDetailsException;
import com.foodwala.exception.OrderDetailsException;
import com.foodwala.exception.RestaurantExecption;
import com.foodwala.model.Customer;
import com.foodwala.model.OrderDetails;
import com.foodwala.model.Restaurant;

public interface OrderDetailsService {
	
	public OrderDetails addOrder(OrderDetails order) throws OrderDetailsException; 
	
	public OrderDetails updateOrder(OrderDetails order) throws OrderDetailsException; 
	
	public OrderDetails removeOrder(OrderDetails order) throws OrderDetailsException; 
	
	public OrderDetails viewOrder(OrderDetails order) throws OrderDetailsException; 
	
	public List<OrderDetails> viewAllOrder(Restaurant res) throws RestaurantExecption,OrderDetailsException;
	
	public List<OrderDetails> viewAllOrder(Customer customer) throws CustomerException,OrderDetailsException;



}
