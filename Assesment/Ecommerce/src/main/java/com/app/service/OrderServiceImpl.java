package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.ProductOutOffStockException;
import com.app.dao.CustomerOrderRepository;
import com.app.dao.ProductRepository;
import com.app.entities.CustomerOrder;
import com.app.entities.Payment;
import com.app.entities.Product;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void processOrder(CustomerOrder order) {
		for(Product product : order.getProducts())
		{
			if(product.isAvailable())
			{
				product.reduceStock(1);
				productRepository.save(product);
			}
			else
			{
				throw new ProductOutOffStockException("Product "+ product.getName() + "Out od Stock");
			}
		}
		order.setStatus("Processed");
		customerOrderRepository.save(order);
	}

	
	@Override
	public void completePayment(CustomerOrder order, double amount) {
		Payment payment = new Payment();
		payment.setAmount(amount);
		payment.setPaymentStatus("pending");
		payment.confirmPayment();
		order.setPayment(payment);
		order.setStatus("Completed");
		customerOrderRepository.save(order);
	}
	
	
}
