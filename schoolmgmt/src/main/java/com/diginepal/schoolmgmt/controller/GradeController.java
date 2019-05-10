package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.repo.GradeRepo;



@Controller
@RequestMapping("grade")
public class GradeController {
	
	@Autowired
	GradeRepo gradeRepo;
	
	@PostMapping (value="/save")
	public Grade save(@RequestBody Grade grade) {
		return gradeRepo.save(grade);
	}
	
	@GetMapping(value="/list")
	public String findAll(Model model){
		List<Grade> list=gradeRepo.findAll();
		model.addAttribute("grade", list);
		return "grade/list";
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
