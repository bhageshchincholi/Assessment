package com.app.service;

import java.util.Map;

public interface InventoryService {
	public void restockItems(Map<Long, Integer> restockQuantitites);
	public void checkAndRestock();
}
