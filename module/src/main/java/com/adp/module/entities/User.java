package com.adp.module.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name="user_name")
	private String userName;
	private String password;
	
	@ManyToMany
	@JoinTable(name="user_roles", 
				joinColumns= @JoinColumn(name="user_id"),
				inverseJoinColumns= @JoinColumn(name ="role_id"))
	
	private Set<Role> roles =new HashSet<>();

	public Object getuserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setpassword(Object password2) {
		// TODO Auto-generated method stub
		
	}

	public void setuserName(Object getuserName) {
		// TODO Auto-generated method stub
		
	}

	

}
