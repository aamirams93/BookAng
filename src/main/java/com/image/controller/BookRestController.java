package com.image.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.image.entity.Book;
import com.image.service.BookService;

@RestController
@CrossOrigin
public class BookRestController {

	@Autowired
	private BookService service;

	@PostMapping("/book")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		String msg = service.upsertBook(book);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> allBooks = service.getAllBooks();
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}
	
	@DeleteMapping("/books/delete/{bookId}")
	public ResponseEntity<String> delete(@PathVariable Integer bookId)
	{
		String msg = service.deleteBookById(bookId);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<List<Book>> bookById(@PathVariable Integer bookId) {
	    List<Book> bookIds = service.getBookById(bookId);
	    return new ResponseEntity<>(bookIds, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Book book)
	{
		String msg = service.updateBook(book);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}


}
