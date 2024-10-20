package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30)
	private String name;
	
	private double price;
	
	private int stock;
	
	// many to many 
//	@ManyToMany(mappedBy = "products")
//	private List<CustomerOrder> orders = new ArrayList<>();
	
	public boolean isAvailable()
	{
		return stock > 0;
	}
	
	// to decrease the stock 
	
	public void reduceStock(int qty)
	{
		this.stock-=qty;
	}
}
