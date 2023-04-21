package com.esunbankbookBorrowing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esunbankbookBorrowing.entity.InventoryEntity;
import com.esunbankbookBorrowing.entity.UserEntity;
import com.esunbankbookBorrowing.service.InventoryService;
import com.esunbankbookBorrowing.service.RecordService;
import com.esunbankbookBorrowing.ultility.BorrowException;

@RestController
@EnableTransactionManagement //設定此controller可以用交易控制
public class BorrowController {
	
	@Autowired
	InventoryService inventoryService;
	@Autowired
	RecordService recordService;

	@PostMapping("/borrow")
	public ResponseEntity<String> borrow(@RequestBody InventoryEntity inventoryEntity, HttpSession session ) {
		
		//確認使用者有先進行登入才能繼續借書流程
		if(session.getAttribute("user")==null) {
			return new ResponseEntity<>("請先進行登入", HttpStatus.BAD_REQUEST);
		}else {
			try {
				Integer userId = ((UserEntity)session.getAttribute("user")).getUserId();
				Integer inventoryId = inventoryEntity.getInventoryId();
				recordService.borrow(userId, inventoryId);
				return new ResponseEntity<>("借閱成功", HttpStatus.OK);
			} catch (BorrowException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}			
		}
	}
	
	@PostMapping("/loan")
	public ResponseEntity<String> loan(@RequestBody InventoryEntity inventoryEntity, HttpSession session) {
		
		//確認使用者有先進行登入才能繼續還書流程
		if(session.getAttribute("user")==null) {
			return new ResponseEntity<>("請先進行登入", HttpStatus.BAD_REQUEST);
		}else {
			try {
				Integer userId = ((UserEntity)session.getAttribute("user")).getUserId();
				Integer inventoryId = inventoryEntity.getInventoryId();
				recordService.loan(userId, inventoryId);
				return new ResponseEntity<>("還書成功", HttpStatus.OK);
			} catch (NullPointerException e) {
				return new ResponseEntity<>("還書操作異常!! 請確認借閱紀錄", HttpStatus.BAD_REQUEST);
			}			
		}
	}

}
