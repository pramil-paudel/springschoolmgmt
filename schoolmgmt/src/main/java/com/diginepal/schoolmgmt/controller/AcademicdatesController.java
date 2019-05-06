package com.diginepal.schoolmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Academicdates;
import com.diginepal.schoolmgmt.exception.GlobalException;
import com.diginepal.schoolmgmt.repo.AcademicdatesRepo;

@RestController
@RequestMapping("academicdates")
public class AcademicdatesController {
	
	@Autowired 
	AcademicdatesRepo academicdatesRepo;
	
	@PostMapping(value="/save")
	public Academicdates save(@Valid @RequestBody Academicdates academicdates, Errors error) {
		
		return academicdatesRepo.save(academicdates); 
	}
	
	@GetMapping(value="/list")
	public List<Academicdates> findAll(){
		return academicdatesRepo.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Academicdates findOne(@PathVariable int id){
		System.out.println(id);
		return academicdatesRepo.findById(id).get();
	}
	
	@PutMapping(value="/update/{id}")
	public Academicdates update(@PathVariable int id,@RequestBody Academicdates academicdates) {
		academicdates.setId(id);
		return academicdatesRepo.save(academicdates);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		Academicdates academicdates=academicdatesRepo.findById(id).get();
		academicdatesRepo.delete(academicdates);
	}

}
