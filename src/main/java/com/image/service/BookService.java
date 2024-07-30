package com.image.service;

import java.util.List;

import com.image.entity.Book;

public interface BookService {

	public String upsertBook(Book book);

	public List<Book> getAllBooks();
	
	public String deleteBookById(Integer bookId);
	
	public List<Book> getBookById(Integer bookId);
	
	public String updateBook(Book book);

}