package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.repo.GradeRepo;



@RestController
@RequestMapping("grade")
public class GradeController {
	
	@Autowired
	GradeRepo gradeRepo;
	
	@PostMapping
	public Grade save(@RequestBody Grade grade) {
		return gradeRepo.save(grade);
	}
	
	@GetMapping
	public List<Grade> findAll(){
		return gradeRepo.findAll();
	}
}
