package com.diginepal.schoolmgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diginepal.schoolmgmt.entities.Student;
import com.diginepal.schoolmgmt.entities.Subjects;
import com.diginepal.schoolmgmt.repo.StudentRepo;
import com.diginepal.schoolmgmt.repo.SubjectsRepo;

@Component
@Transactional
public class StudentService {
	@Autowired StudentRepo  studentRepo;
	@Autowired SubjectsRepo subjectsRepo;
	
	public Student saveStudent(Student student) {
		List<Subjects> subjects = student.getSubjects();
		List<Subjects> sublist=new ArrayList<Subjects>();
		for(Subjects sub:subjects) {
			sublist.add(subjectsRepo.findById(sub.getId()).get());
		}
		student.setSubjects(sublist);
		return studentRepo.save(student);
	}
	

}
