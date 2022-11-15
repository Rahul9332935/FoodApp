package com.foodwala.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodwala.exception.CategoryException;
import com.foodwala.model.Category;

@Repository
public interface CategoryService {

	
	
	public Category addCategory(Category category) throws CategoryException;
	
	public Category updateCategory(Category category) throws CategoryException;
	
	public Category removeCategory(Category category) throws CategoryException;
	
	public Category viewCategory(Category category) throws CategoryException;
	
	public List<Category> viewAllCategory() throws CategoryException;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
