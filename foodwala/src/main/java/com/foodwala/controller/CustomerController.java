package com.foodwala.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.CategoryException;
import com.foodwala.exception.CustomerException;
import com.foodwala.model.Category;
import com.foodwala.model.Customer;
import com.foodwala.service.CustomerService;

@RestController
public class CustomerController {
	
@Autowired
private CustomerService customerService; 

@PostMapping("/customer")
public ResponseEntity<Customer> addCustomer( @RequestBody Customer customer) throws CustomerException{
	
	 Customer cus = customerService.addCustomer(customer);
	 
	 return new ResponseEntity<Customer>(cus, HttpStatus.OK);

}

@PutMapping("/customer")
public ResponseEntity<Customer> updateCustomer( @RequestBody Customer customer, @RequestParam(required = false) String key) throws CustomerException{
	
	     Customer cus =  customerService.updateCustomer(customer,key);
	     
	return  new ResponseEntity<Customer>(cus ,HttpStatus.ACCEPTED);
	
}

@DeleteMapping("/customer")
public ResponseEntity<Customer> deleteCustomer( @RequestBody Customer customer, @RequestParam(required = false) String key) throws CustomerException{
	
	     Customer cus =  customerService.removeCustomer(customer,key);
	     
	return  new ResponseEntity<Customer>(cus ,HttpStatus.ACCEPTED);
	
}



@GetMapping("/getcustomer")
public ResponseEntity<Customer> viewCustomer( @RequestBody Customer customer) throws CustomerException{
	
	Customer cus = customerService.viewCustomer(customer);
	
	return  new ResponseEntity<Customer>(cus,HttpStatus.ACCEPTED);
	
}



@GetMapping("/customer")
public ResponseEntity<List<Customer>> viewAllCustomer() throws CustomerException{
	
	
	List<Customer> cus = customerService.viewAllCustomer();
	
	return  new ResponseEntity<List<Customer>>(cus,HttpStatus.ACCEPTED);
	
}


}
