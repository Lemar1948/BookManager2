package com.bard.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class UserRole extends Model {
	
	@ManyToMany(mappedBy = "userRoles")
	private Set<User> user = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
	@Column(name="title")
	private ListRole listRole;
	
	public UserRole() {
		
	}
	
	public UserRole(long id) {
		super(id);
	}

	public ListRole getListRole() {
		return listRole;
	}

	public void setListRole(ListRole listRole) {
		this.listRole = listRole;
	}
	
	
	
}
