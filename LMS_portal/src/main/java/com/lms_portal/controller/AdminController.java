package com.lms_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms_portal.entity.Admin;
import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.service.AdminService;
import com.lms_portal.service.CourseService;
import com.lms_portal.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService admin_serv;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
//	----------------------------------  ADMIN  -------------------------------
//	@GetMapping("/")
//	public List<Admin> getadmin(){
//		return admin_serv.getAdminData();
//	}
	
//
	@PostMapping("/addnew")
	public List<Admin> postadmin(@RequestBody Admin a){
		return admin_serv.postAdminData(a);
	}
	
	@PostMapping("/update")
	public List<Admin> putadmin(@RequestBody Admin a){
		return admin_serv.updateAdminData(a);
	}
	
//	------------------------------------   USER   ---------------------------------
	@GetMapping("/user")
	public List<User> findallUser(){
		return userService.allUser();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getuserbyId(@PathVariable long id ){
		return userService.getbyid(id);
	}
	
	@PostMapping("/user/addnew")
	public List<User> postuser(@RequestBody User u){
		return userService.postUserData(u);
	}
	
	@PutMapping("/user/update")
	public List<User> putuser(@RequestBody User u){
		return userService.putUserData(u);
	}
	
	@DeleteMapping("/user/{id}/deactivat")
	public List<User> deleteUser(@PathVariable Long id){
		return userService.deactiveUser(id);
	}
	
//	-------------------------------------  COURSE ---------------------------------
	
	@GetMapping("/courses")
	public List<Course> getall(){
		return courseService.allCourse();
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getcourse(@PathVariable long id ){
		return courseService.getbyid(id);
	}
	
	
	@PostMapping("/courses/addnew")
	public List<Course> addnewCourse(@RequestBody Course courses){
		return courseService.postCourse(courses);
	}


	@PutMapping("/courses/update")
	public List<Course> updateCourse(@RequestBody Course courses){
		return courseService.updateCourse(courses);
	}
	
	@DeleteMapping("/courses/{id}/delete")
	public List<Course> deletecourse(@PathVariable long id ){
		return courseService.deleteCourse(id);
	}
}
