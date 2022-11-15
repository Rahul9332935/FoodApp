package com.foodwala.service;

import com.foodwala.exception.FoodCartException;
import com.foodwala.exception.ItemException;
import com.foodwala.model.FoodCart;

public interface FoodCartService {

public FoodCart saveFoodCart(FoodCart cart);
	
	public FoodCart addItemToCart(Integer cart, Integer item)throws FoodCartException, ItemException;
	
	public FoodCart viewCartById(Integer cartId);
	
	public FoodCart increaseQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException , ItemException;
	
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException , ItemException;
	
	public FoodCart removeItem(Integer cartId, Integer itemId) throws FoodCartException ;
	
	public FoodCart clearCart(Integer cartId) throws FoodCartException ;
	
}
