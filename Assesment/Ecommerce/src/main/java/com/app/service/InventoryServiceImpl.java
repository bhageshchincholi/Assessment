package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.ProductNotFound;
import com.app.dao.ProductRepository;
import com.app.entities.Product;
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void restockItems(Map<Long, Integer> restockQuantitites) {
		for(Map.Entry<Long,Integer> entry : restockQuantitites.entrySet())
		{
			Product product = productRepository.findById(entry.getKey()).orElseThrow(()-> new ProductNotFound("Product Not Found"));
			int qtyAdd = entry.getValue();
			product.setStock(product.getStock()+qtyAdd);
			productRepository.save(product);
		}

	}

	@Override
	public void checkAndRestock() {
		List<Product> products = productRepository.findAll();
		for(Product product : products)
		{
			if(product.getStock() < 10)
			{
				System.out.println("Product "+ product.getName()+ "to be restock !!");
			}
		}
	}
	
}
