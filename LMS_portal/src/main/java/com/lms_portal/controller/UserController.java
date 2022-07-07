package com.lms_portal.controller;
import com.fasterxml.jackson.databind.JsonNode;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.service.CourseService;
import com.lms_portal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	CourseService courseService;
	
//	----------------------------- USER --------------------------------
//	@GetMapping("/")
//	public List<User> findallUser(){
//		return userService.allUser();
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getuserbyId(@PathVariable long id ){
		return userService.getbyid(id);
	}
	
//	@PostMapping("/addnew")
//	public List<User> postuser(@RequestBody User u){
//		return userService.postUserData(u);
//	}
	
//	----------------------------- COURSES --------------------------------
	
//  Get all Courses
	@GetMapping("/courses")
	public List<Course> getall(){
		return courseService.allCourse();
	}
	
//	get course by ID
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getcourse(@PathVariable long id ){
		return courseService.getbyid(id);
	}
	
//	get course by Course Name
	@GetMapping("/courses/search")
	public ResponseEntity<List<Course>> search(@RequestParam String courseName){
		return courseService.getCourseByName(courseName);
	}
	
//	get course by Course Price Range
	@GetMapping("/courses/range")
	public ResponseEntity<List<Course>> searchByRange(@RequestParam Double low, @RequestParam Double high){
		return courseService.getCourseByPriceRange(low, high);
	}
	
//	-----------------------------  ENROLL COURSE  ----------------------------------
	
//	Get Order LIst
		@GetMapping("/{id}/enrolled_courses")
		public List<Course> getEnrolled(@PathVariable Long id){
			return courseService.getEnrolledCourses(id);
		}
		
//	Enroll courses
		@PostMapping("/enrollcourses")
		public List<User> postdata(@RequestBody JsonNode requestBody){
			return userService.enrollCourse(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
		}
		
		
//		-----------------------------  CART ----------------------------------

		
//	add to cart 
		@PostMapping("/addtocart")
		public List<User> postCart(@RequestBody JsonNode requestBody){
			return userService.cartCourse(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
		}
		
//	Delete Course from Cart
		@DeleteMapping("/cart/removecourses")
		public List<User> removeCart(@RequestBody JsonNode requestBody){
			return userService.removeCartCourse(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
		}

//  Buy all cart courses
		@PutMapping("/{id}/cart/buy")
		public List<User> buyAllCourse(@PathVariable Long id){
			return userService.buyAllCourse(id);
		}
	
		
//		-----------------------------  SAVE COURSE  ----------------------------------
		

		
//Save for later courses
		@PostMapping("/save_course")
		public List<User> saveCourse(@RequestBody JsonNode requestBody){
			return userService.saveforlater(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
		}

		
}
	

