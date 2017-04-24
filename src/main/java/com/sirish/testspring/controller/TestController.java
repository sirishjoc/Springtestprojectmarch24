package com.sirish.testspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checking")
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public String showIndex() {
		return "This is for checking if api are created";
	}

}
