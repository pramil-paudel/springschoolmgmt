package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Subjects;
import com.diginepal.schoolmgmt.repo.SubjectsRepo;



@RestController
@RequestMapping("subjects")
public class SubjectsController {
	@Autowired
	SubjectsRepo subjectsRepo;
	
	@PostMapping
	public Subjects save(@RequestBody Subjects subjects) {
		return subjectsRepo.save(subjects);
	}
	
	@GetMapping
	public List<Subjects> findAll(){
		return subjectsRepo.findAll();
	}
}
