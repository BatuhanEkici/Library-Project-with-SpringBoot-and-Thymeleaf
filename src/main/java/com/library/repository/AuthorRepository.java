package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	
}
