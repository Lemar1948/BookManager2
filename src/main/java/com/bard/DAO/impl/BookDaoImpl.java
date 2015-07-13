package com.bard.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bard.DAO.BookDao;
import com.bard.model.Book;

@Named("bookDaoImpl")
public class BookDaoImpl implements BookDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Book> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Book");
		return query.list();
	}

	@Override
	@Transactional
	public void save(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

}
