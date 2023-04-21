package com.esunbankbookBorrowing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esunbankbookBorrowing.entity.InventoryEntity;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryEntity, Integer>{

}
