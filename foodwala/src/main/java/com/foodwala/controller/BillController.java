package com.foodwala.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.BillException;
import com.foodwala.model.Bill;
import com.foodwala.service.BillService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BillController {
	
	@Autowired
	private BillService bService;
	
	@PostMapping("/bills")
	public ResponseEntity<Bill> saveBill( @RequestBody  Bill bill) throws BillException{
		
		Bill b= bService.addBill(bill);
		
		return new ResponseEntity<Bill>(b,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/bills")
	public ResponseEntity<Bill> updateBill( @RequestBody Bill bill) throws BillException{
		Bill b= bService.updateBill(bill);
		return new ResponseEntity<Bill>(b,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/bills")
	public ResponseEntity<Bill> removeBill( @RequestBody Bill bill) throws BillException{
		
		Bill b=bService.removeBill(bill);
		
		return new ResponseEntity<Bill>(b,HttpStatus.OK);
	}
	
	@GetMapping("/bills")
	public ResponseEntity<Bill> viewBill( @RequestBody Bill bill) throws BillException{
		
		Bill b= bService.viewBill(bill);
		return new ResponseEntity<Bill>(b,HttpStatus.ACCEPTED);
	}
	
//	@GetMapping("/getBillsByDate/{startDate}/{endDate}")
//	public ResponseEntity<List<Bill>> viewBillbyDate(@PathVariable("startDate") LocalDate startDate,@PathVariable("endDate") LocalDate endDate) throws BillException {
//		System.out.println("sdkghdfjk");
//		List<Bill> bl= bService.viewBillsD(startDate, endDate);
//		
//		return new ResponseEntity<List<Bill>>(bl, HttpStatus.OK);
//	}
//	
	
	
	
	

}
