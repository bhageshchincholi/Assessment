package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	// many orders having one user
	// many ----> one
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	// Many orders ---> Many products
	// One ---> Many
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_products",
			   joinColumns = @JoinColumn(name = "order_id"),
			   inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<>();
	
	// One order having one payment 
	// One ----> One
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id",referencedColumnName = "id")
	private Payment payment;	
}
