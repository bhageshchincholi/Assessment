package com.app.Exception;

public class ProductOutOffStockException extends RuntimeException {
	private String message;
	
	public ProductOutOffStockException(String message)
	{
		super();
		this.message = message;
	}
}
