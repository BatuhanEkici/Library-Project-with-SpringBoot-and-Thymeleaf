package com.library.service;

import java.util.List;

import com.library.model.Author;

public interface AuthorService {
	
	List<Author> getAllAuthors();
	void saveAuthor(Author author);
	Author getAuthorById(long id);
	void deleteAuthorById(long id);
}
