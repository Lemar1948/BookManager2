package com.bard.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bard.DAO.BookDao;
import com.bard.model.Book;

@Controller
@RequestMapping("/book")
public class MainController {
	
	@Inject
	@Qualifier("bookDaoImpl")
	private BookDao bookDao;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView showBookList() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Book> booksList = bookDao.getList();
		
		modelAndView.addObject("books", booksList);
		modelAndView.setViewName("bookslist");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, 
             consumes = "application/json")
	public @ResponseBody String add(@RequestBody Book book) {
		
		System.out.println("INSIDE ADD 1 " + book.getTitle() + " : " + book.getDescription());
		bookDao.save(book);
		System.out.println("INSIDE ADD 2");
		
		return "OK";
	
	}
	
	/*
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("login");
		
		return modelAndView;
	}
	*/
	
}
