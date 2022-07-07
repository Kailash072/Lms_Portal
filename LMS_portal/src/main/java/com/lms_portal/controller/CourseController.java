package com.lms_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.lms_portal.entity.Course;
import com.lms_portal.repo.CourseRepo;
import com.lms_portal.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseService courseService;
	@Autowired
	CourseRepo crepo;
	

	@GetMapping("/")
	public List<Course> getall(){
		return courseService.allCourse();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getcourse(@PathVariable long id ){
		return courseService.getbyid(id);
	}

//	@GetMapping("/{course_name}")
//	public ResponseEntity<Course> getbycourse(@PathVariable("course_name") String course_name){
//		return courseService.getByName(course_name);
//	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Course>> searchByName(@RequestParam String courseName){
		return courseService.getCourseByName(courseName);
	}
	@GetMapping("/range")
	public ResponseEntity<List<Course>> searchByRange(@RequestParam Double low, @RequestParam Double high){
		return courseService.getCourseByPriceRange(low, high);
	}
	
}
