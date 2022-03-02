package com.bookapp.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.config.DbConfig;
import com.bookapp.model.persitance.Book;
import com.bookapp.model.service.BookService;

public class BookController {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =  new AnnotationConfigApplicationContext(DbConfig.class);
		BookService bookService= (BookService) ctx.getBean("bookService");
		
		
		System.out.println(bookService.getAllBooks());
		bookService.addBook(new Book("ppp123", "JAVA 8", "mmmmmmmmm", 900.0));
				System.out.println(bookService.getAllBooks());
	}
}
