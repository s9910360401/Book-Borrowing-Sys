package com.esunbankbookBorrowing.service;

import com.esunbankbookBorrowing.entity.InventoryEntity;

public interface InventoryService {

	InventoryEntity getInventory(Integer inventoryId);

	void changeInventory(InventoryEntity inventoryVO);
	
}
