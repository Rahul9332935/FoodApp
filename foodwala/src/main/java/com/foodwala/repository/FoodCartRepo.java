package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwala.model.FoodCart;

public interface FoodCartRepo extends JpaRepository<FoodCart, Integer> {

}
