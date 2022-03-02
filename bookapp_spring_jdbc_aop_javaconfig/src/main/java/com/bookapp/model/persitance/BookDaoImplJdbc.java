package com.bookapp.model.persitance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BookDaoImplJdbc implements BookDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BookDaoImplJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Book> getAllBooks() {
		
		String sql="select * from Book";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
	}

	@Override
	public Book addBook(Book book) {
		
		String sql = "insert into book(isbn,title,author,price) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice() });
		return book;
	}
		

	@Override
	public void deleteBook(int id) {
		String sql = "delete from book where id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void updateBook(int id, Book book) {
		String sql = "update book set price=? where id=?";
		jdbcTemplate.update(sql, new Object[] {book.getPrice(),book.getId() });
		
	}

	@Override
	public Book getBookById(int id) {
		
		return jdbcTemplate.queryForObject("select * from book where id=?", new BookRowMapper(), id);
		
	}
	
}
