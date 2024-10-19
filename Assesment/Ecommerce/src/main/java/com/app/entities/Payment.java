package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double amount;
	
	private String paymentStatus;
	
	// ONE ORDER HAVING ONE PAYMENT
	 //ONE ---> ONE
	@OneToOne(mappedBy = "payment")
	private CustomerOrder order;
	
	// payment will be completed 
	public void confirmPayment()
	{
		this.paymentStatus = "completed";
	}
}
