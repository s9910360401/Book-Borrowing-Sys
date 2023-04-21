package com.esunbankbookBorrowing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esunbankbookBorrowing.entity.InventoryEntity;
import com.esunbankbookBorrowing.repository.InventoryRepo;

@Service
public class InventoryServiceImp implements InventoryService{
	
	@Autowired
	InventoryRepo inventoryRepo;
	
	@Override
	public InventoryEntity getInventory(Integer inventoryId) {
		
		return inventoryRepo.findById(inventoryId).orElse(null);
	}

	@Override
	public void changeInventory(InventoryEntity inventoryVO) {
		inventoryRepo.save(inventoryVO);
		
	}
	
}
