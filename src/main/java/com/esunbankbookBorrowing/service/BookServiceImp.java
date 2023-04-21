package com.esunbankbookBorrowing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esunbankbookBorrowing.entity.BookEntity;
import com.esunbankbookBorrowing.repository.BookRepo;

@Service
public class BookServiceImp implements BookService{
	
	@Autowired
	BookRepo bookRepo;

	@Override
	public BookEntity addBook(BookEntity bookEntity) {
		
		return bookRepo.save(bookEntity);
	}

	@Override
	public BookEntity findBook(String isbn) {

		return bookRepo.findById(isbn).get();
	}

	@Override
	public void delete(String isbn) {
		
		bookRepo.deleteById(isbn);
	}

}
