package com.sirish.testspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sirish.testspring.domain.Book;

public interface BookRepository extends MongoRepository<Book, String>{
	public Book findByName(String name);
	public Book findByISBN(String ISBN);

}