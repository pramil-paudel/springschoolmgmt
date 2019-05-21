package com.diginepal.schoolmgmt.restcontroller;

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
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Academicdates;
import com.diginepal.schoolmgmt.entities.Branch;
import com.diginepal.schoolmgmt.entities.Company;
import com.diginepal.schoolmgmt.repo.BranchRepo;
import com.diginepal.schoolmgmt.repo.CompanyRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;


@CrossOrigin("*")
@RestController
@RequestMapping("branch")

public class BranchRestController {
		
		@Autowired
		BranchRepo branchRepo;
		
		@Autowired
		CompanyRepo companyRepo;
		
		@GetMapping(value="/new")
		public ModelAndView form() 
		{
			ModelAndView model = new ModelAndView("branch/form");
			model.addObject("companies", companyRepo.findAll());
			return model;	
			}
		
		@GetMapping
		public ModelAndView list() {
			return new ModelAndView("branch/list");
		}
		
		@PostMapping 
		public ResponseEntity<?> save(@RequestBody Branch branch) {
			ResponseMessage response=new ResponseMessage();
			branch=branchRepo.save(branch);
			if(branch==null) {
				response=Response.badrequest();
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			response=Response.created();
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		
		@GetMapping (value="/list")
		public ResponseEntity<?> findAll(){
			ResponseMessage response=new ResponseMessage();
			List<Branch> list=branchRepo.findAll();
			if(list.isEmpty()) {
				response=Response.resourcenotfound();
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}		
		@GetMapping (value="/{id}")
		public ResponseEntity<?> findOne (@PathVariable int id){
			Branch branch=branchRepo.findById(id).get();
			ResponseMessage response=new ResponseMessage();
			if(branch==null) {
				response=Response.resourcenotfound();
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(branch, HttpStatus.OK);
		}
		@PutMapping(value="/update/{id}")
		public ResponseEntity<?> update(@PathVariable int id,@RequestBody Branch branch) {
			ResponseMessage response=new ResponseMessage();
			Branch search=branchRepo.findById(id).get();
			if(search==null) {
				response=Response.resourcenotfound();
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			else {
				branch.setId(id);
				branch=branchRepo.save(branch);
				response=Response.successful();
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}
		@DeleteMapping(value="/delete/{id}")
		public ResponseEntity<?> delete(@PathVariable int id) {
			ResponseMessage response=new ResponseMessage();
			Branch branch=branchRepo.findById(id).get();
			if(branch==null) {
				response=Response.resourcenotfound();
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			else {
			branchRepo.delete(branch);
			response=Response.successful();
			return new ResponseEntity<>(response,HttpStatus.OK);
			}
		}
	}


