package com.bookapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.persitance.Book;
import com.bookapp.model.persitance.BookDao;
import com.bookapp.model.persitance.BookDaoImplHib;

@Service(value="bookService")
@Transactional
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	private Logger logger= (Logger) LoggerFactory.getLogger(BookServiceImpl.class);
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public BookServiceImpl() {
	}
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.getAllBooks();
	}

	@Override
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}

}