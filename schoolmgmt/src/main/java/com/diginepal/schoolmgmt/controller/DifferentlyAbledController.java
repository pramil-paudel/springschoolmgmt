package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.diginepal.schoolmgmt.entities.Employee;
import com.diginepal.schoolmgmt.repo.DifferentlyAbledRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@Controller
@RequestMapping("differentlyable")
public class DifferentlyAbledController {
	@Autowired
	DifferentlyAbledRepo differentlyAbledRepo;
	
	@PostMapping 
	public ResponseEntity<?> save(@RequestBody DifferentlyAbleType differentlyable) {
		ResponseMessage response=new ResponseMessage();
		differentlyable=differentlyAbledRepo.save(differentlyable);
		if(differentlyable==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}	
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<DifferentlyAbleType> list=differentlyAbledRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findOne (@PathVariable int id){
		DifferentlyAbleType differentlyable=differentlyAbledRepo.findById(id).get();
		ResponseMessage response=new ResponseMessage();
		if(differentlyable==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(differentlyable, HttpStatus.OK);
	}
	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody DifferentlyAbleType differentlyable) {
		ResponseMessage response=new ResponseMessage();
		DifferentlyAbleType search=differentlyAbledRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			differentlyable.setId(id);
			differentlyable=differentlyAbledRepo.save(differentlyable);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		DifferentlyAbleType differentlyabled=differentlyAbledRepo.findById(id).get();
		differentlyAbledRepo.delete(differentlyabled);
}
}
