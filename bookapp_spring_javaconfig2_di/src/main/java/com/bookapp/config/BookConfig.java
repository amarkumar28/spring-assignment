package com.bookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bookapp.model.persitance.BookDao;
import com.bookapp.model.persitance.BookDaoImpl;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.bookapp"})
public class BookConfig {
	
	@Bean(name="bookService")
	public BookService getBookService(BookDao bookDao)
	{
		BookServiceImpl bookServiceImpl =new BookServiceImpl();
		bookServiceImpl.setBookDao(bookDao);
		return bookServiceImpl;
	}
	@Bean
	public BookDao getBookDao()
	{
		return new BookDaoImpl();
	}

}
