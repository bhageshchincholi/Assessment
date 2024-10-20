package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exception.OrderNotFound;
import com.app.dao.CustomerOrderRepository;
import com.app.entities.CustomerOrder;
import com.app.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerOrderRepository orderRepository;
	
	@PostMapping("/process")
	public ResponseEntity<?> processOrder(@RequestBody CustomerOrder order)
	{
		orderService.processOrder(order);
		return ResponseEntity.ok("Order processed Successfully !!!");
	}
	
	@PostMapping("/completePayment")
	public ResponseEntity<?> completePayment(@RequestParam Long orderId,@RequestParam double amount)
	{
		CustomerOrder order = orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFound("Order Not Found !!"));
		orderService.completePayment(order, amount);
		return ResponseEntity.ok("Payment Completed Successfully !!");
	}
}
