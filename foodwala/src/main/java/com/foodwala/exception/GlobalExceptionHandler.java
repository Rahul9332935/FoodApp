package com.foodwala.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.foodwala.exception.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> logInException(LoginException lE, WebRequest wR){
		
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(lE.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<ErrorDetails> billExceptionHandler(BillException nhfe, WebRequest wR){
		
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nhfe.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<ErrorDetails> itemExceptionHandler(ItemException nhfe, WebRequest wR){
		
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nhfe.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException mave){
		
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(mave.getMessage()); //Validation error
		errorDetails.setDetails(mave.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
	

	

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException nhfe, WebRequest wR){
		
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nhfe.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<ErrorDetails> noAddressFoundExceptionpHnadler(AddressException ae ,WebRequest wR){
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ae.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails , HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(OrderDetailsException.class)
	public ResponseEntity<ErrorDetails> noAddressFoundExceptionpHnadler(OrderDetailsException ae ,WebRequest wR){
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ae.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails , HttpStatus.NOT_FOUND);
	
	}
	
	
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> noCustomerExecptionHnadler(CustomerException ce ,WebRequest wR){
		
        ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> universalExceptionHandler(Exception e ,WebRequest wR){
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	

	
}
