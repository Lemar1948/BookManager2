package com.bard.DAO;

import java.util.List;

import com.bard.model.Book;

public interface BookDao {
	public List<Book> getList();
	public void save(Book book);
}
