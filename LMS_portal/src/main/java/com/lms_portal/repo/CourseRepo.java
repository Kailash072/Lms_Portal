package com.lms_portal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms_portal.entity.Course;



@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{
	
	Course findById(long id);
    
	@Query("SELECT c FROM Course c WHERE c.course_name LIKE %?1%")
	public List<Course> findByNameCourse(String cName);

	@Query("SELECT e FROM Course e WHERE e.price BETWEEN ?1 AND ?2")
	public List<Course> findByRange(Double lrange, Double hrange);
}
