package com.adp.module.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")

public class Role {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column (name="description")
	private String description;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users =new HashSet();

}
