package com.foodwala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.foodwala.exception.FoodCartException;
import com.foodwala.exception.ItemException;
import com.foodwala.model.FoodCart;
import com.foodwala.model.Item;
import com.foodwala.repository.FoodCartRepo;
import com.foodwala.repository.ItemRepo;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	private FoodCartRepo cr;
	
	@Autowired
	private ItemRepo ir;
	
	

	@Override
	public FoodCart saveFoodCart(FoodCart cart) {
		return cr.save(cart);
	}
	

	@Override
	public FoodCart addItemToCart(Integer cartId, Integer itemId) throws FoodCartException, ItemException{
		Optional<FoodCart> fc=cr.findById(cartId);
		Optional<Item> itm=ir.findById(itemId);
		
		if(!fc.isPresent()) {
			throw new FoodCartException("cart not found");
		}
		if(!itm.isPresent()) {
			throw new ItemException("item not found");
		}
		
		FoodCart cart=fc.get();
		Item item=itm.get();
		
		cart.getItemList().add(item);
		
		return cr.save(cart);
		
	}
	
	

	@Override
	public FoodCart viewCartById(Integer cartId) {
		Optional<FoodCart> optl=cr.findById(cartId);
		return optl.get();
	}
	
	
	@Override
	public FoodCart increaseQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		Optional<FoodCart> fc=cr.findById(cartId);
		Optional<Item> it=ir.findById(itemId);
		if(!it.isPresent()) {
			throw new ItemException("item not found");
		}
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			List<Item>list=fcart.getItemList();
			list.forEach(i->{
				if(i.equals(it.get())) {
					i.setQuantity(i.getQuantity()+quantity);
				}
			});
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}
	
	
	@Override
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		Optional<FoodCart> fc=cr.findById(cartId);
		Optional<Item> it=ir.findById(itemId);
		if(!it.isPresent()) {
			throw new ItemException("item not found");
		}
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			List<Item>list=fcart.getItemList();
			list.forEach(i->{
				if(i.equals(it.get())) {
					i.setQuantity(i.getQuantity()-quantity);
				}
			});
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}
	
	
	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) throws FoodCartException {
		Optional<FoodCart> fc=cr.findById(cartId);
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			fcart.getItemList().removeIf(x -> (x.getItemId()==itemId));
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}



	@Override
	public FoodCart clearCart(Integer cartId) throws FoodCartException {
		Optional<FoodCart> fc=cr.findById(cartId);
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			fcart.getItemList().clear();;
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}
}
