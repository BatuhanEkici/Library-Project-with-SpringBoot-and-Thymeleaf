package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	@Query("Select b from Book b where b.name LIKE %?1%"
			+ "OR b.isbn LIKE %?1%"
			+"OR b.author.name LIKE %?1%"
			+"OR b.publisher.name LIKE %?1%"
			)
	public List<Book> findByName(String keyword);
	
}
