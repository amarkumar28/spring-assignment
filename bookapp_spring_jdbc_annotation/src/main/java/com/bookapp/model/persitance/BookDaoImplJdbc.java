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
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BookDaoImplJdbc implements BookDao{

	private DataSource dataSource;
	
	@Autowired
	public BookDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<Book> getAllBooks() {
		List<Book> books=new ArrayList<Book>();
		Connection connection=null;
		System.out.println("Details of All books");
		try {
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from Book");
			
			ResultSet rs=preparedStatement.executeQuery();
			
			
			while(rs.next())
			{
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getDouble(5));
				books.add(book);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return books;
	}

	@Override
	public Book addBook(Book book) {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement pstmt=connection.prepareStatement
					("insert into book(isbn,title,author,price) values(?,?,?,?)");
			
			pstmt.setString(1,book.getIsbn());
			pstmt.setString(2,book.getTitle());
			pstmt.setString(3,book.getAuthor());
			pstmt.setDouble(4,book.getPrice());
			
			pstmt.executeUpdate();
			
			System.out.println("Record inserted in book");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement pstmt =connection.prepareStatement("delete from book where id=?");
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			System.out.println("Book removed with id: "+id);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateBook(int id, Book book) {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement pstmt=connection.prepareStatement
					("update book set price=? where id=?");
			
			pstmt.setDouble(1,book.getPrice());
			pstmt.setInt(2,book.getId());
			pstmt.executeUpdate();
			
			System.out.println("book price updated to "+ book.getPrice()+ "for id: "+ book.getId());
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public Book getBookById(int id) {
		Book book=null;
		Connection connection=null;
		PreparedStatement preparedStatement;
		try {
			connection=dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select * from Book where id=?");
			preparedStatement.setInt(1,3);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			if(rs.next())
			{
				book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getDouble(5));;
			}
			System.out.println("Book found");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		
		return book;
	}
	
}
