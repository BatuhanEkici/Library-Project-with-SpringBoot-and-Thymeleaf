package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Author;
import com.library.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public void saveAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(long id) {
		Author author = authorRepository.findById(id).get();
		return author;
	}

	@Override
	public void deleteAuthorById(long id) {
		authorRepository.deleteById(id);
	}

}
