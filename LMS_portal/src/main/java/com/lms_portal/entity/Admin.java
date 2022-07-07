package com.lms_portal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "admin")
	private List<User> user;
	
	@OneToMany(mappedBy = "admin")
	private List<Course> courses;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(long id, String name, List<User> user, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.courses = courses;
	}

	
public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


@JsonManagedReference
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
@JsonManagedReference
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	


}
