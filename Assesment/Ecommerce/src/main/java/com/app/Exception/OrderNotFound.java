package com.app.Exception;

public class OrderNotFound extends RuntimeException{
	private String message;
	public OrderNotFound(String message)
	{
		this.message = message;
	}
}
