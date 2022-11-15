package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwala.model.OrderDetails;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

}
