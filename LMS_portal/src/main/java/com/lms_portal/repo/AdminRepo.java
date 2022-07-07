package com.lms_portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms_portal.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{

}
