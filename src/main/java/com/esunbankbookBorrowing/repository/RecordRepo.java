package com.esunbankbookBorrowing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esunbankbookBorrowing.entity.RecordEntity;


@Repository
public interface RecordRepo extends JpaRepository<RecordEntity, Integer>{
	
	List<RecordEntity> findByUserIdAndInventoryId(Integer userId, Integer InventoryId);
	RecordEntity findByUserIdAndInventoryIdAndReturnTimeIsNull(Integer userId, Integer InventoryId);
}
