package com.image.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.image.entity.Book;
import com.image.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	private BookRepository repository;

	public BookServiceImpl(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public String upsertBook(Book book) {
		repository.save(book);
		return "Record Inserted";
	}

	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public String deleteBookById(Integer bookId) {
		repository.deleteById(bookId);
		return "Book Deleted";
	}



	@Override
	public List<Book> getBookById(Integer bookId) {
	    Optional<Book> findById = repository.findById(bookId);

	    if (findById.isPresent()) {
	        return Collections.singletonList(findById.get());
	    } else {
	        return Collections.emptyList();
	    }
	}

	@Override
	public String updateBook(Book book) {
		Integer bookId = book.getBookId();

		Book save  = repository.save(book);
		if (bookId  == null) {
			return "Record Inserted...!!";
		} else {
			return "Book Updated";
		}
	}

	
	
}