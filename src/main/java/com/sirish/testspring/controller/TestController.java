package com.sirish.testspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sirish.testspring.domain.Book;
import com.sirish.testspring.repository.BookRepository;

@RestController
@RequestMapping("/checking")
public class TestController {
	
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String showIndex() {
		Book book = new Book("Testing mongo", "Testing mongo", "Testing mongo", "Testing mongo", "Testing mongo", 9, "Testing mongo");
		this.bookRepository.save(book);
		return "This is for checking if api are created";
	}

}
