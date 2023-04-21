package com.esunbankbookBorrowing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esunbankbookBorrowing.entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, String>{

}
