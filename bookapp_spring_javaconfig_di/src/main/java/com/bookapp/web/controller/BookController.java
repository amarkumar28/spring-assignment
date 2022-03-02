package com.bookapp.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.config.BookConfig;
import com.bookapp.model.service.BookService;


public class BookController {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(BookConfig.class);
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("book.xml");
		BookService bookService= (BookService) ctx.getBean("bookService");
		
		System.out.println(bookService.getAllBooks());
		
	}
}
