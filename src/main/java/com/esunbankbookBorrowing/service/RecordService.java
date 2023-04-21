package com.esunbankbookBorrowing.service;



public interface RecordService {

	void borrow(Integer userId, Integer inventoryId);

	void loan(Integer userId, Integer inventoryId);
	
}
