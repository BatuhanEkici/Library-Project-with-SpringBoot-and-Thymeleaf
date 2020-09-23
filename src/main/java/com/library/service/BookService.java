package com.library.service;

import java.util.List;

import com.library.model.Book;


public interface BookService {

	List<Book> getAllBooks();
	void saveBook(Book book);
	Book getBookById(long id);
	void deleteBookById(long id);
	List<Book> findBookByName(String keyword);
}
