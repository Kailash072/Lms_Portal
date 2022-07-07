package com.lms_portal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users", 
uniqueConstraints = { 
  @UniqueConstraint(columnNames = "email") 
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
//	@Email
	private String email;
	

	@ManyToMany
	@JoinTable(name = "cart", joinColumns = {@JoinColumn( name = "user_id") },inverseJoinColumns = {@JoinColumn( name = "course_id") })
	private List<Course> cart;

	
	@ManyToMany
	@JoinTable(name = "enrollment", joinColumns = {@JoinColumn( name = "user_id") },inverseJoinColumns = {@JoinColumn( name = "course_id") })
	private List<Course> enroll;

	@ManyToMany
	@JoinTable(name = "saveforlater", joinColumns = {@JoinColumn( name = "user_id") },inverseJoinColumns = {@JoinColumn( name = "course_id") })
	private List<Course> save_courses;
	
	@ManyToOne
	Admin admin;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



public User(long id, String name, String email, List<Course> cart, List<Course> enroll, List<Course> save_courses,
			Admin admin) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cart = cart;
		this.enroll = enroll;
		this.save_courses = save_courses;
		this.admin = admin;
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



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public List<Course> getCart() {
	return cart;
}



public void setCart(List<Course> cart) {
	this.cart = cart;
}



public List<Course> getEnroll() {
	return enroll;
}



public void setEnroll(List<Course> enroll) {
	this.enroll = enroll;
}



public List<Course> getSave_courses() {
	return save_courses;
}



public void setSave_courses(List<Course> save_courses) {
	this.save_courses = save_courses;
}



@JsonBackReference
	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}




}
