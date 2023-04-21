package com.esunbankbookBorrowing.service;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esunbankbookBorrowing.entity.InventoryEntity;
import com.esunbankbookBorrowing.entity.RecordEntity;
import com.esunbankbookBorrowing.repository.InventoryRepo;
import com.esunbankbookBorrowing.repository.RecordRepo;
import com.esunbankbookBorrowing.ultility.BorrowValidate;
import com.esunbankbookBorrowing.ultility.InventoryStatus;

@Service
public class RecordServiceImp implements RecordService{
	
	@Autowired
	RecordRepo recordRepo;
	@Autowired
	InventoryRepo inventoryRepo;

	@Override
	@Transactional //設定此方法會需要有交易控制
	public void borrow(Integer userId, Integer inventoryId) {
		
		InventoryEntity inventoryVO = inventoryRepo.findById(inventoryId).get();
				
		RecordEntity recordVO = new RecordEntity();
		recordVO.setUserId(userId);
		recordVO.setInventoryId(inventoryId);
		recordRepo.save(recordVO);
		
		//將出借驗證的方法(是否為在庫狀態)放在這裡藉此產生例外看交易控制有正常運作嗎，發生例外將不會有借閱紀錄進入資料庫
		BorrowValidate.borrowValidate(inventoryVO);
		
		//若沒發生例外這邊會將庫存的狀態改成出借中
		inventoryVO.setStatus(InventoryStatus.出借中);
		inventoryRepo.save(inventoryVO);
		
	}

	@Override
	@Transactional //設定此方法會需要有交易控制
	public void loan(Integer userId, Integer inventoryId) {
		
		InventoryEntity inventoryVO = inventoryRepo.findById(inventoryId).get();
		
		//先將Iinventory狀態改成在庫
		inventoryVO.setStatus(InventoryStatus.在庫);
		inventoryRepo.save(inventoryVO);
		
		//這邊只從資料庫調出尚未還書的借閱紀錄(若這邊發生例外，則上面修改的在庫狀態會被ROLLBACK)
		RecordEntity recordVO = recordRepo.findByUserIdAndInventoryIdAndReturnTimeIsNull(userId, inventoryId);
		//更新借閱紀錄的還書時間
		recordVO.setReturnTime(new Timestamp(System.currentTimeMillis()));
		recordRepo.save(recordVO);
				
	}

}
