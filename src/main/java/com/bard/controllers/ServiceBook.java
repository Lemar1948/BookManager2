package com.bard.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bard.model.Book;

@Named("serviceBook")
public class ServiceBook {
	
	@Inject
	private SessionFactory sessionFactory;
	
	public ServiceBook() {
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Book> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Book");
		return query.list();
	}
	
}
