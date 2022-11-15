package com.foodwala.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.CustomerException;
import com.foodwala.exception.OrderDetailsException;
import com.foodwala.exception.RestaurantExecption;
import com.foodwala.model.Customer;
import com.foodwala.model.OrderDetails;
import com.foodwala.model.Restaurant;
import com.foodwala.service.OrderDetailsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService oService;
	
	@PostMapping("/orders")
	public ResponseEntity<OrderDetails> addOrder( @RequestBody OrderDetails order) throws OrderDetailsException{
		
		 OrderDetails od= oService.addOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/orders")
	public ResponseEntity<OrderDetails> removeOrder( @RequestBody OrderDetails order) throws OrderDetailsException{
		
		OrderDetails od= oService.removeOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.OK);
	}
	
	@PutMapping("/orders")
	public ResponseEntity<OrderDetails> updateOrder( @RequestBody OrderDetails order) throws OrderDetailsException {
		OrderDetails od= oService.updateOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.OK);
		
	}
	
	@GetMapping("/orders")
	public ResponseEntity<OrderDetails> viewOrder( @RequestBody OrderDetails order) throws OrderDetailsException{
		
		OrderDetails od= oService.viewOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.OK);
	}
	
	@GetMapping("/AllRestaurantOrders")
	public ResponseEntity<List<OrderDetails>> viewOrderR( @RequestBody Restaurant res) throws RestaurantExecption, OrderDetailsException {
		List<OrderDetails> od=oService.viewAllOrder(res);
		return new ResponseEntity<List<OrderDetails>>(od,HttpStatus.OK);
	}
	
	@GetMapping("/AllCustomerOrders")
	public  ResponseEntity<List<OrderDetails>> viewOrderC( @RequestBody Customer customer) throws CustomerException, OrderDetailsException{
		
		List<OrderDetails> od=oService.viewAllOrder(customer);
		return new ResponseEntity<List<OrderDetails>>(od,HttpStatus.OK);
		
	}
	
	
}
