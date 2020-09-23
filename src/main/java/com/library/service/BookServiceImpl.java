package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);		
	}

	@Override
	public Book getBookById(long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findBookByName(String keyword) {	
		return bookRepository.findByName(keyword);
	}

}
