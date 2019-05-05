package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.DifferentlyAbleType;
import com.diginepal.schoolmgmt.repo.DifferentlyAbledRepo;

@RestController
@RequestMapping("differentlyabled")
public class DifferentlyAbledController {
	@Autowired
	DifferentlyAbledRepo differentlyAbledRepo;
	
	@PostMapping
	public void save(@RequestBody DifferentlyAbleType differentlyAbleType) {
		differentlyAbledRepo.save(differentlyAbleType);
		
	}
	
	@GetMapping
	public List<DifferentlyAbleType> findAll(){
		return differentlyAbledRepo.findAll();
	}

}
