package com.foodwala.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.CategoryException;
import com.foodwala.exception.ItemException;
import com.foodwala.exception.RestaurantExecption;
import com.foodwala.model.Category;
import com.foodwala.model.Item;
import com.foodwala.model.Restaurant;
import com.foodwala.service.ItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ItemController {

	@Autowired
	private ItemService iService;
	
	@PostMapping("/items")
	public ResponseEntity<Item> addItem( @RequestBody Item item) throws ItemException{
		Item it=iService.addItem(item);
		return new ResponseEntity<Item> (it, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/items")
	public ResponseEntity<Item> updateItem( @RequestBody Item item) throws ItemException{
		Item it= iService.updateItem(item);
		
		return new ResponseEntity<Item> (it, HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/items")
	public ResponseEntity<Item> removeItem( @RequestBody Item item) throws ItemException{
		Item it= iService.removeItem(item);
		
		return new ResponseEntity<Item> (it, HttpStatus.OK);
	}
	
	@GetMapping("/items")
	public ResponseEntity<Item> viewItem( @RequestBody Item item) throws ItemException {
		
		Item it= iService.viewItem(item);
		
		return new ResponseEntity<Item> (it, HttpStatus.OK);
	}
	
	@GetMapping("/items/{name}")
	public ResponseEntity<List<Item>> viewAllItemsByName(@PathVariable String name) throws ItemException{
		
		List<Item> it= iService.viewAllItemsByName(name);
		
		return new ResponseEntity<List<Item>> (it, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/itemsCate")
	public ResponseEntity<List<Item>> viewAllCategoryItems( @RequestBody Category category) throws ItemException, CategoryException {
		
		List<Item> it=iService.viewAllCItems(category);
		return new ResponseEntity<List<Item>> (it, HttpStatus.OK);
		
	}
	
	@GetMapping("/itemsRest")
	public ResponseEntity<List<Item>>  viewAllRItems( @RequestBody Restaurant res) throws ItemException, RestaurantExecption {
		
		List<Item> it=iService.viewAllRItems(res);
		return new ResponseEntity<List<Item>> (it, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
}
