package com.foodwala.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	
	
	private LocalDateTime billDate;
	
	//@Max(value = 10,message = "total item should not more then 10")
	private Integer totalItem;
	
	//@Max(value = 10000, message = "max cost should not more then 10000")
	private double totalCost;
	
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails order;
	
	
	
	
	
}
