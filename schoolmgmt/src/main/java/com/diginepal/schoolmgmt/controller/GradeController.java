package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Faculty;
import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.repo.GradeRepo;



@RestController
@RequestMapping("grade")
public class GradeController {
	
	@Autowired
	GradeRepo gradeRepo;
	
	@PostMapping (value="/save")
	public Grade save(@RequestBody Grade grade) {
		return gradeRepo.save(grade);
	}
	
	@GetMapping (value="/list")
	public List<Grade> findAll(){
		return gradeRepo.findAll();
	}
	
	@GetMapping (value="/{id}")
	public Grade findOne (@PathVariable int id){
		return gradeRepo.findById(id).get();
	}

	@PutMapping(value="/update/{id}")
	public Grade update(@PathVariable int id,@RequestBody Grade grade) {
		grade.setId(id);
		return gradeRepo.save(grade);
}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		Grade grade=gradeRepo.findById(id).get();
		gradeRepo.delete(grade);
	}

}
