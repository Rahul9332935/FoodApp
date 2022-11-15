package com.foodwala.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.BillException;
import com.foodwala.exception.CustomerException;
import com.foodwala.model.Bill;
import com.foodwala.repository.BillRepo;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepo bRepo;
	
	@Override
	public Bill addBill(Bill bill) throws BillException {
		
		Integer id= bill.getBillId();
		Optional<Bill> b= bRepo.findById(id);
		if(b.isPresent()) {
			throw new BillException("bill already exist...");
		}
		
		 Bill sBill= bRepo.save(bill);
		
		return sBill;
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		
		Integer id= bill.getBillId();
		Optional<Bill> b= bRepo.findById(id);
		if(b.isPresent()) {
			Bill uBill= bRepo.save(bill);
			return uBill;
		}
		else {
			throw new BillException("no data avalible, change bill id.."+bill.getBillId());
		}
	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {

		Integer bId=bill.getBillId();
		Optional<Bill> b= bRepo.findById(bId);
		if(b.isPresent()) {
			
			Bill fbill=b.get();
			bRepo.delete(fbill);
			return fbill;
			
		}
		else {
			throw new BillException("incorrect Bill id...");
		}
	}

	@Override
	public Bill viewBill(Bill bill) throws BillException {
		
		Integer bId=bill.getBillId();
		Optional<Bill> b= bRepo.findById(bId);
		if(b.isPresent()) {
			
			Bill fbill=b.get();
			
			return fbill;
			
		}
		else {
			throw new BillException("incorrect Bill id...");
		}
		
	}

//	@Override
//	public List<Bill> viewBillsD(LocalDate startDate, LocalDate endDate) throws BillException {
//		List<Bill> bl= bRepo.findByBillDateBetween(startDate, endDate);
//		if(bl.size()==0) {
//			throw new BillException("no bill available from date "+startDate+" to "+endDate);
//		}
//		return bl;
//	}

	@Override
	public List<Bill> viewBillsCId(Integer custId) throws CustomerException, BillException {
		
		return null;
	}

	@Override
	public double calculateTotalCost(Bill Bill) throws BillException {
		
		return 0;
	}

	
	
	
}
