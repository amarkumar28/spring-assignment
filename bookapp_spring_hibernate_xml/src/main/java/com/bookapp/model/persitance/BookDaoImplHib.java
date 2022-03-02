package com.bookapp.model.persitance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class BookDaoImplHib implements BookDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public BookDaoImplHib(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//helper method 
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
		
	@Override
	public List<Book> getAllBooks() {
		
		return getSession().createQuery("from Book",Book.class).getResultList();
	}

	@Override
	public Book addBook(Book book) {
		
		getSession().persist(book);
		return book;
	}
		

	@Override
	public void deleteBook(int id) {
		Book bookToDelete= getBookById(id);
		getSession().delete(bookToDelete);
	}

	@Override
	public void updateBook(int id, Book book) {
		getSession().merge(book);
	}

	@Override
	public Book getBookById(int id) {
		
		Book book=getSession().get(Book.class, id);
		return book;
		
	}
	
}
