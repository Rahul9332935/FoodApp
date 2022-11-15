package com.foodwala.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.CustomerException;
import com.foodwala.exception.OrderDetailsException;
import com.foodwala.exception.RestaurantExecption;
import com.foodwala.model.Customer;
import com.foodwala.model.OrderDetails;
import com.foodwala.model.Restaurant;
import com.foodwala.repository.OrderDetailsRepo;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	
	@Autowired
	private OrderDetailsRepo oRepo; 
	
	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderDetailsException {
		
		if(order==null) {
			throw new OrderDetailsException("Order object should not be null");
		}
		
		OrderDetails od= oRepo.save(order);
		return od;
		
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderDetailsException {
	
		if(order==null) {
			throw new OrderDetailsException("Order object should not be null");
		}
		Integer oid=order.getOrderId();
		if(oid==null) {
			throw new OrderDetailsException("order id should not be null");
		}
		Optional<OrderDetails> od= oRepo.findById(oid);
		if(od.isEmpty()) {
			throw new OrderDetailsException("Enter correct order id ");
		}
		OrderDetails ods= od.get();
		return ods;
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) throws OrderDetailsException {
		if(order==null) {
			throw new OrderDetailsException("Order object should not be null");
		}
		Integer oid=order.getOrderId();
		if(oid==null) {
			throw new OrderDetailsException("order id should not be null");
		}
		Optional<OrderDetails> od= oRepo.findById(oid);
		if(od.isEmpty()) {
			throw new OrderDetailsException("Enter correct order id ");
		}
		OrderDetails ods= od.get();
		 oRepo.delete(ods);
		 return ods;
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) throws OrderDetailsException {
		if(order==null) {
			throw new OrderDetailsException("Order object should not be null");
		}
		Integer oid=order.getOrderId();
		if(oid==null) {
			throw new OrderDetailsException("order id should not be null");
		}
		Optional<OrderDetails> od= oRepo.findById(oid);
		if(od.isEmpty()) {
			throw new OrderDetailsException("Enter correct order id ");
		}
		OrderDetails ods= od.get();
		return ods;
	}

	@Override
	public List<OrderDetails> viewAllOrder(Restaurant res) throws RestaurantExecption, OrderDetailsException {
		
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrder(Customer customer) throws CustomerException, OrderDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
