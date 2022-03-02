package com.bookapp.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.bookapp.model.persitance.Book;
import com.bookapp.model.service.BookService;

public class BookController {
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext ctx =  new AnnotationConfigApplicationContext(DbConfig.class);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("book.xml");
		BookService bookService= (BookService) ctx.getBean("bookService");
		
		
		System.out.println(bookService.getAllBooks());
		bookService.addBook(new Book("ppp12345", "JAVA 8", "qqqq", 1000.0));
				System.out.println(bookService.getAllBooks());
	}
}
