package com.esunbankbookBorrowing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esunbankbookBorrowing.entity.BookEntity;
import com.esunbankbookBorrowing.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	// RestFul風格 API(/book):Get(查詢)/Post(新增)/Delete(刪除)/Put(更新)
	
	@GetMapping("/book")
	public ResponseEntity<?> query(@RequestBody BookEntity bookEntity) {
		
		BookEntity bookVO = bookService.findBook(bookEntity.getIsbn());
		return new ResponseEntity<>(bookVO, HttpStatus.OK);

	}

	@PostMapping("/book")
	public ResponseEntity<?> add(@RequestBody BookEntity bookEntity) {

		BookEntity bookVO = bookService.addBook(bookEntity);
		return new ResponseEntity<>(bookVO, HttpStatus.OK);

	}
	
	@PutMapping("/book")
	public ResponseEntity<?> update(@RequestBody BookEntity bookEntity) {

		BookEntity bookVO = bookService.addBook(bookEntity);
		return new ResponseEntity<>(bookVO, HttpStatus.OK);

	}
	
	@DeleteMapping("/book")
	public ResponseEntity<?> delete(@RequestBody BookEntity bookEntity) {

		bookService.delete(bookEntity.getIsbn());
		return new ResponseEntity<>("刪除成功!!!", HttpStatus.OK);

	}

}
