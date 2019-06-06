package com.diginepal.schoolmgmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository <Student, Integer> {
	public List<Student> findByGradeIdAndSectionId(int gradeid, int sectionid);

}
