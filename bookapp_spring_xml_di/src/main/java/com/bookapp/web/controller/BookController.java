package com.bookapp.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.persitance.Book;
import com.bookapp.model.service.BookService;



public class BookController {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("book.xml");
		BookService bookService= (BookService) ctx.getBean("bookService");
		
		System.out.println(bookService.getAllBooks());
		book
	}
}
