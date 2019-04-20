package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

}
