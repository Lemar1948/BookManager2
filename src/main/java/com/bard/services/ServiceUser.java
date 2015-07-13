package com.bard.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bard.model.User;

@Named("serviceUser")
public class ServiceUser implements UserDetailsService{
	
	@Inject
	private SessionFactory sessionFactory;
	
	public ServiceUser() {
		
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
		query.setParameter("username", username);
		
		User result = (User) query.uniqueResult();
		
		if(result == null) throw new UsernameNotFoundException("username: " + username + "not found!");
		
		return result;
	}

}
