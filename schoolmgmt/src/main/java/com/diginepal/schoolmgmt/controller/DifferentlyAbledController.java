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


import com.diginepal.schoolmgmt.entities.DifferentlyAbleType;
import com.diginepal.schoolmgmt.repo.DifferentlyAbledRepo;

@Controller
@RequestMapping("differentlyable")
public class DifferentlyAbledController {
	@Autowired
	DifferentlyAbledRepo differentlyAbledRepo;
	
	@PostMapping (value="/save")
	public void save(@RequestBody DifferentlyAbleType differentlyAbleType) {
		differentlyAbledRepo.save(differentlyAbleType);
		
	}
	
	@GetMapping(value="/list")
	public String findAll(Model model){
		List<DifferentlyAbleType> list=differentlyAbledRepo.findAll();
		model.addAttribute("differentlyable", list);
		return "differentlyable/list";
	}
	
	
	@GetMapping(value="/{id}")
	public DifferentlyAbleType findOne(@PathVariable int id){
		System.out.println(id);
		return differentlyAbledRepo.findById(id).get();
	}
	
	@PutMapping(value="/update/{id}")
	public DifferentlyAbleType update(@PathVariable int id,@RequestBody DifferentlyAbleType differentlyabletype) {
		differentlyabletype.setId(id);
		return differentlyAbledRepo.save(differentlyabletype);
	}

	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		DifferentlyAbleType differentlyabled=differentlyAbledRepo.findById(id).get();
		differentlyAbledRepo.delete(differentlyabled);
}
}
