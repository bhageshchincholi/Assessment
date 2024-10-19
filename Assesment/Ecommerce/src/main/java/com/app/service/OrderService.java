package com.app.service;

import com.app.entities.CustomerOrder;

public interface OrderService {
	public void processOrder(CustomerOrder order);
	public void completePayment(CustomerOrder order,double amount);
}
