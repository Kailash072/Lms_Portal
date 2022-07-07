package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lms_portal.entity.Admin;
import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.repo.AdminRepo;
import com.lms_portal.repo.CourseRepo;
import com.lms_portal.repo.UserRepo;

@Service
public class AdminService {
	@Autowired
	AdminRepo adminrepo;
	
	
	@Autowired
	CourseRepo courserepo;
	
//	public List<Admin> getAdminData() {
//		return adminrepo.findAll();
//	}

	public List<Admin> postAdminData(@RequestBody Admin a) {
		adminrepo.save(a);
		return adminrepo.findAll();
	}
	public List<Admin> updateAdminData(@RequestBody Admin a) {
		adminrepo.save(a);
		return adminrepo.findAll();
	}
	
	


}
