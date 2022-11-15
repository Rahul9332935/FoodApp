package com.foodwala.service;

import java.util.List;

import com.foodwala.exception.CategoryException;
import com.foodwala.exception.ItemException;
import com.foodwala.exception.RestaurantExecption;
import com.foodwala.model.Category;
import com.foodwala.model.Item;
import com.foodwala.model.Restaurant;

public interface ItemService {
	
	public Item addItem(Item item) throws ItemException;
	
	public Item updateItem(Item item) throws ItemException;
	
	public Item removeItem(Item item) throws ItemException;
	
	public Item viewItem(Item item) throws ItemException;
	
	public List<Item> viewAllCItems(Category category) throws ItemException, CategoryException;
	
	public List<Item> viewAllRItems(Restaurant res) throws ItemException, RestaurantExecption;
	
	public List<Item> viewAllItemsByName(String name) throws ItemException;

}
