package com.foodwala.service;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.CategoryException;
import com.foodwala.model.*;
import com.foodwala.repository.CategoryRepo;



@Service
public class CategoryServiceImpl implements CategoryService  {


	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Category addCategory(Category category) throws CategoryException {
		
	
	    
		Optional<Category> checkPresence = categoryRepo.findById(category.getCatId());
		
		if(checkPresence.isPresent()) 
			
			throw new CategoryException("This Category is already resistered...Please add another one. ");
		
		else 
			
			return categoryRepo.save(category);
		
	}

	
	
	@Override
	public Category updateCategory(Category category) throws CategoryException {

     Optional<Category> checkPresence =  categoryRepo.findById(category.getCatId());
		
	 if(checkPresence.isPresent()) 
		 
		 return categoryRepo.save(category);
		 
	 else 
		 
		throw new CategoryException("Invalid Category...Please select right one."); 
		 	
	}

	

	@Override
	public Category removeCategory(Category category) throws CategoryException {
		
		
		Optional<Category> checkPresence = categoryRepo.findById(category.getCatId());
		
		if(checkPresence.isPresent()){
			
			categoryRepo.delete(checkPresence.get());
			return checkPresence.get();
		
		}else {
			
			throw new CategoryException("Invalid Category ...Pleeae select right one.");
		}
	
	}

	

	
	@Override
	public Category viewCategory(Category category) throws CategoryException {


		Optional<Category> viewCategory = categoryRepo.findById(category.getCatId());
		
		
		if(viewCategory.isPresent())
			return viewCategory.get();
		else
			throw new CategoryException("Not found... Please choose another one.");
		

	}

	
	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		
		
		List<Category> categoryList = categoryRepo.findAll();
		
		if(categoryList.size() != 0) 
			return categoryList;
		else
			throw new CategoryException("No category available...");
		
		
	
	}

	

	
}
