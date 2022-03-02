package com.bookapp.model.persitance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository(value="bookDao")
public class BookDaoImpl implements BookDao
{
	private Map<Integer, Book> booksMap;
	private static int counter = 0;
	
	public Map<Integer, Book> getBooksMap() {
		return booksMap;
	}
	public void setBooksMap(Map<Integer, Book> booksMap) {
		this.booksMap = booksMap;
	}
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(booksMap.values());
	}
	public Book addBook(Book book) {
		book.setId(++counter);
		booksMap.put(counter, book);
		return booksMap.get(counter);
	}
	public void deleteBook(int id) {
		booksMap.remove(id);
	}
	public void updateBook(int id, Book book) {
		booksMap.put(id, book);
	}
	public Book getBookById(int id) {
		return booksMap.get(id);
	}
}
