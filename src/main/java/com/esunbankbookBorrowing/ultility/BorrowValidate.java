package com.esunbankbookBorrowing.ultility;

import com.esunbankbookBorrowing.entity.InventoryEntity;

public class BorrowValidate {
	
	public static boolean borrowValidate(InventoryEntity inventoryVO) {
		if (!(inventoryVO.getStatus().equals(InventoryStatus.在庫))) {
			throw new BorrowException("目前書本狀態為"+inventoryVO.getStatus().toString());
		}else {
			return true;
		}
	}

}
