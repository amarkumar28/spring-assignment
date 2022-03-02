package com.bookapp.model.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.persitance.Book;
import com.bookapp.model.persitance.BookDao;
import com.bookapp.model.persitance.BookDaoImplJdbc;

@Service(value="bookService")
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	//private Logger logger= LoggerFactory.getLogger(BookServiceImpl.class);
	
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
		return bookDao.getBookById(id)
				;
	}

}
