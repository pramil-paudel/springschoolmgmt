package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.MotherLanguage;
import com.diginepal.schoolmgmt.repo.MotherLanguageRepo;



@RestController
@RequestMapping("motherlanguage")
public class MotherLanguageController {
	@Autowired
	MotherLanguageRepo motherLanguageRepo;
	
	@PostMapping
	public MotherLanguage save(@RequestBody MotherLanguage motherLanguage) {
		return motherLanguageRepo.save(motherLanguage);
	}
	
	@GetMapping
	public List<MotherLanguage> findAll(){
		return motherLanguageRepo.findAll();
	}
}