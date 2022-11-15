package com.foodwala.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodwala.model.Bill;
@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {
	
//	@Query("select b from Bill b where b.billDate BETWEEN :startDate AND :endDate")
//	public List<Bill> findByBillDateBetween(LocalDate startDate , LocalDate endDate);
	
}
