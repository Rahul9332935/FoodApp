package com.foodwala.service;

import java.time.LocalDate;
import java.util.List;

import com.foodwala.exception.BillException;
import com.foodwala.exception.CustomerException;
import com.foodwala.model.Bill;



public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	
	public Bill updateBill(Bill bill) throws BillException;
	
	public Bill removeBill(Bill bill) throws BillException;
	
	public Bill viewBill (Bill bill) throws BillException;
	
	//public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException;
	
	public List<Bill> viewBillsCId(Integer custId) throws CustomerException, BillException;
	
	public double calculateTotalCost(Bill Bill) throws BillException;
	
	

}
