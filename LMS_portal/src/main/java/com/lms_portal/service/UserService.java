package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.repo.CourseRepo;
import com.lms_portal.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	CourseRepo courserepo;
	
	
	public List<User> allUser(){
		return userrepo.findAll();
	}
	
	public ResponseEntity<User> getbyid(long id) {
		return ResponseEntity.ok(userrepo.findById(id));
	}
	
	public List<User> postUserData(@RequestBody User u){
		userrepo.save(u);
		return userrepo.findAll();
	}
	
	public List<User> putUserData(@RequestBody User u){
		userrepo.save(u);
		return userrepo.findAll();
	}
	
	public List<User> deactiveUser(@PathVariable Long id){
		userrepo.deleteById(id);
		return userrepo.findAll();
	}

	public List<User> cartCourse(long user_id, long courses_id){
		User u = userrepo.findById(user_id);
		Course c = courserepo.findById(courses_id);
		List<Course> temp = u.getCart();
		temp.add(c);
		userrepo.save(u);
		return userrepo.findAll();	
	}
	
	public List<User> removeCartCourse(long user_id, long courses_id){

		User u = userrepo.findById(user_id);
		Course c = courserepo.findById(courses_id);
		List<Course> temp = u.getCart();
		temp.remove(c);
		userrepo.save(u);
		return userrepo.findAll();	
	}
	
	
	public List<User> enrollCourse(long user_id, long courses_id){
		User u = userrepo.findById(user_id);
		Course c = courserepo.findById(courses_id);
		List<Course> temp = u.getEnroll();
		temp.add(c);
		userrepo.save(u);
		return userrepo.findAll();	
	}
	
	

	public List<User> saveforlater(long user_id, long courses_id){
		User u = userrepo.findById(user_id);
		Course c =	courserepo.findById(courses_id);
		List<Course> temp = u.getSave_courses();
		temp.add(c);
		userrepo.save(u);
		return userrepo.findAll();	
	}

	
	public List<User> buyAllCourse(long user_id){
		User u = userrepo.findById(user_id);
		List<Course> temp_cart = u.getCart();
		List<Course> temp = u.getEnroll();
		temp.addAll(temp_cart);

		temp_cart.clear();
		userrepo.save(u);
		return userrepo.findAll();	
	}




}
