package com.esunbankbookBorrowing.service;

import com.esunbankbookBorrowing.entity.BookEntity;

public interface BookService {

	BookEntity addBook(BookEntity bookEntity);

	BookEntity findBook(String isbn);

	void delete(String isbn);

}
