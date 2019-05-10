package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Academicdates;
import com.diginepal.schoolmgmt.repo.AcademicdatesRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@RestController
@RequestMapping("academicdates")
public class AcademicdatesController {
	
	@Autowired 
	AcademicdatesRepo academicdatesRepo;
	
	@GetMapping(value="/")
	public String form() {
		return "form";
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<?> save(@RequestBody Academicdates academicdates) {
		ResponseMessage response=new ResponseMessage();
		academicdates=academicdatesRepo.save(academicdates);
		if(academicdates==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/list")
	public List<Academicdates> findAll(Model model){
		List<Academicdates> list=academicdatesRepo.findAll();
		model.addAttribute("academicdates", list);
		return list;
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findOne(@PathVariable int id,@RequestBody Academicdates acdemicdates ){
		ResponseMessage response= new ResponseMessage();
		Academicdates search= academicdatesRepo.findById(id).get();
		if (search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			
			response=Response.successful();
			return new ResponseEntity<>(search, HttpStatus.OK);
		}
			
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
