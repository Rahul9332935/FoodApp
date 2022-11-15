package com.foodwala.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.CustomerException;
import com.foodwala.exception.ResturentException;
import com.foodwala.model.Address;
import com.foodwala.model.CurrantUserSession;
import com.foodwala.model.Customer;
import com.foodwala.model.Item;
import com.foodwala.model.Restaurant;
import com.foodwala.repository.AddressRepo;
import com.foodwala.repository.ItemRepo;
import com.foodwala.repository.ResturentRespo;
import com.foodwala.repository.SessionRepo;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class ResturentServiceImpl implements ResturentService{
	@Autowired
	public ResturentRespo rservice;
	
	@Autowired
	public ItemRepo itemrepo;
	
	@Autowired
	public AddressRepo aRepo;
	
	@Autowired
	public SessionRepo sRepo;

	@Override
	public Restaurant SaveResturent(Restaurant resturent) {
		
		List<Item> items=resturent.getItemList();
		
		for(Item item:items) {
			item.getRestaurants().add(resturent);
		}
		
		return rservice.save(resturent);
	}

	@Override
	public Restaurant UpdateResturent(Restaurant resturent, String key) throws ResturentException {
		

		
	     CurrantUserSession loggedInUser= sRepo.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new ResturentException("Please provide a valid key to update a Restaurant");
		}
		
		
		if(resturent.getRestaurantId() == loggedInUser.getUserId()) {
		
			Optional<Restaurant> resturentobj=rservice.findById(resturent.getRestaurantId());
			
			Restaurant updateResturent=resturentobj.get(); 
			
		
			
		         List<Item> items=resturent.getItemList();	
		         
		     	if(updateResturent==null) {
					throw new ResturentException("Resturent not found by the given Id");
				}
			     

				List<Item> item=resturent.getItemList();
				for(Item item1:items) {
					item1.getRestaurants().add(resturent);
				}
				
			
						
			    return rservice.save(resturent);
			
		}
		else
			throw new ResturentException("Invalid Restaurant Details, please login first");
		

	
	}

	@Override
	public String DelateResturent(Restaurant resturent,String key) throws ResturentException {
		


		
	     CurrantUserSession loggedInUser= sRepo.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new ResturentException("Please provide a valid key to update a Restaurant");
		}
		
		
		if(resturent.getRestaurantId() == loggedInUser.getUserId()) {
		
			 
			Optional<Restaurant> DResturent=rservice.findById(resturent.getRestaurantId());
		
	
			 if(DResturent.isPresent()) {
				 Restaurant drest=DResturent.get();
				
				 rservice.deleteById(resturent.getRestaurantId());
					
					return "Resturent delation sussfully";
				
				 
			 }
			 throw new ResturentException("resturent not present in database which you want to remove");
			
		}
		else
			throw new ResturentException("Invalid Restaurant Details, please login first");
		

		 
	}


	

@Override
	public Restaurant viewResturent(Restaurant resturent) throws Exception {
		
		Optional<Restaurant> res=rservice.findById(resturent.getRestaurantId());
		
		Restaurant rest=res.get();
		if(rest!=null) {
			return rest;
		}
		
		throw new Exception("Resturent not found given by id");
	}
	
	@Override
	public List<Restaurant> getResturentByAddress(String city) throws Exception {
		List<Restaurant> list=rservice.findAll();
		
	
		
		List<Restaurant> list2=new ArrayList<>();
		for(Restaurant r:list) {
			if(r.getAddress().getCity().equals(city)) {
				list2.add(r);
			}
			
		}
		
		if(list2.size()==0) {
			throw new Exception("no restaurant in city "+city);
		}
		
		return list2;
		
	}

	@Override
	public List<Restaurant> ViewResturentByItem(String itemnaem) throws ResturentException {
		
         List<Restaurant> resturents=rservice.findAll();
		
		 List<Restaurant> resturent=new ArrayList<>();
		
		for(Restaurant rest:resturents) {
			
			  List<Item> itms=rest.getItemList();
			  
			  for(Item itm:itms) {
				  if(itm.getItemName().equalsIgnoreCase(itemnaem)) {
					  resturent.add(rest);
					  break;
				  }
			  }
			
		}
		if(resturent.size()==0) {
			throw new ResturentException("item not found in ay resturent");
		}
		
		return resturent;
	}




}
