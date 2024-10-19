package com.app.Exception;

public class ProductNotFound extends RuntimeException {
	private String message;
	public ProductNotFound(String message)
	{
		this.message = message;
	}
}
