package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwala.model.CurrantUserSession;

@Repository
public interface SessionRepo extends JpaRepository<CurrantUserSession, Integer> {
	
	
	public CurrantUserSession findByUuid(String uuid);
	
}