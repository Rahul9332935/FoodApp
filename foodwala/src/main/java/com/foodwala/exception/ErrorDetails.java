package com.foodwala.exception;

import java.time.LocalDateTime;

import com.foodwala.model.Bill;
import com.foodwala.model.OrderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDetails {


	private LocalDateTime timeStamp;
	private String message;
	private String details;
	
}
