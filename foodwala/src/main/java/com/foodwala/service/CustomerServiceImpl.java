package com.foodwala.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.foodwala.exception.CategoryException;
import com.foodwala.exception.CustomerException;
import com.foodwala.model.Category;
import com.foodwala.model.CurrantUserSession;
import com.foodwala.model.Customer;
import com.foodwala.repository.CustomerRepo;
import com.foodwala.repository.SessionRepo;


@Service
public class CustomerServiceImpl implements CustomerService {
	

	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private SessionRepo sRepo;
	
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> checkcustomer = customerRepo.findById(customer.getCustomerId());
		
		if(checkcustomer.isPresent()) {
			
			throw new CustomerException("Customer is already registerd ");
		}
		
		else {
			
			return customerRepo.save(customer);
					
		}
		
	}

	
	@Override
	public Customer updateCustomer(Customer customer,String key) throws CustomerException {
		
		
		//--------------------------------
		
		CurrantUserSession loggedInUser= sRepo.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		
	
		
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
		
			
			Optional<Customer> checkCustomer = customerRepo.findById(customer.getCustomerId());
			
			if(checkCustomer.isPresent()) {
				
				return customerRepo.save(customer);
				
			}
			
			else {
				
				throw new CustomerException("Customer does not exist with this Id");
			}
			
			
			
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");

		
		
		//-------------------------*------
	
		
		
	}
	

	@Override
	public Customer removeCustomer(Customer customer, String key) throws CustomerException {
		
		
		
		
		//---------------------------
		

		CurrantUserSession loggedInUser= sRepo.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
	
		
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
		
			Optional<Customer> checkCustomer = customerRepo.findById(customer.getCustomerId());
			
			if(checkCustomer.isPresent()) {
				
				customerRepo.deleteById(checkCustomer.get().getCustomerId());
				
				return checkCustomer.get();
				
			}else {
				
				throw new CustomerException("Customer does not exist ..specify correct one");
				
			   }
				
			
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");
		
		//--------------------------
		
	
		
	}
	

	@Override
	public Customer viewCustomer(Customer customer) throws CustomerException {
	
		Optional<Customer> viewCustomer = customerRepo.findById(customer.getCustomerId());
		
		if(viewCustomer.isPresent()) {
			
			return viewCustomer.get();
			
		}else {
			
			throw new CustomerException("Customer does not exist ... choose another one");
			
		   }
		
	}
	


	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		
        List<Customer> customerList = customerRepo.findAll();
        
        if(customerList.size()==0) {
        	
        	throw new CustomerException("No customer available");
        	
        }else {
        	return customerList;
        	
        	
        }
		
	}
	

	
}
