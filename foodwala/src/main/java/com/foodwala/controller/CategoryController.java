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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.CategoryException;
import com.foodwala.model.Category;
import com.foodwala.service.CategoryService;

@RestController
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException{
		
		return new ResponseEntity<Category>(categoryService.addCategory(category),HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/categories")
	public ResponseEntity<Category> updateCategory( @RequestBody Category category) throws CategoryException{
		
		
		return  new ResponseEntity<Category>(categoryService.updateCategory(category),HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/categories")
	public ResponseEntity<Category> removeCategory( @RequestBody Category category) throws CategoryException {
		
		return  new ResponseEntity<Category>(categoryService.removeCategory(category),HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getcategories")
	public ResponseEntity<Category> viewCategory( @RequestBody Category category) throws CategoryException{
		
		return  new ResponseEntity<Category>(categoryService.viewCategory(category),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> viewAllCategory() throws CategoryException{
		
		
		return  new ResponseEntity<List<Category>>(categoryService.viewAllCategory(),HttpStatus.ACCEPTED);
		
	}
	
	
}
