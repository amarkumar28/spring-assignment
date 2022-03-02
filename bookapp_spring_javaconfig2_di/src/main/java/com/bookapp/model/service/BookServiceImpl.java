package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.persitance.Book;
import com.bookapp.model.persitance.BookDao;
import com.bookapp.model.persitance.BookDaoImpl;


public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public BookServiceImpl() {
	}

	
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}



}
