package com.foodwala.repository;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwala.model.Category;
import com.foodwala.model.Item;



@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	public List<Item> findAllByItemName(String name);
	
	public List<Item> findAllByCategory(Category category);
	public Item findByitemName(String itemName);



}
