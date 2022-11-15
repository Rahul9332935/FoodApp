package com.foodwala.service;

import java.util.List;
import com.foodwala.exception.CategoryException;
import com.foodwala.exception.CustomerException;
import com.foodwala.model.Category;
import com.foodwala.model.Customer;


public interface CustomerService {
	
    public Customer addCustomer(Customer customer) throws CustomerException;
	
//	public Customer updateCustomer(Customer customer) throws CustomerException;
	
//	public Customer removeCustomer(Customer customer) throws CustomerException;
	
	public Customer viewCustomer(Customer customer) throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;


	public Customer updateCustomer(Customer customer, String key) throws CustomerException;

	public Customer removeCustomer(Customer customer, String key) throws CustomerException;
	

}
