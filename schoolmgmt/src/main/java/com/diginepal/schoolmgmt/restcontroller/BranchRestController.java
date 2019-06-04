package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		
		
		//EXTRA
		@ModelAttribute
		public void models(Model model) {
			model.addAttribute("companies", companyRepo.findAll());
		}
		
		@GetMapping(value="/new")
		public ModelAndView form()
		{
			ModelAndView model = new ModelAndView("branch/form");
			Branch branch= new Branch();
			model.addObject("branch",branch);
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
		//step 1
		@GetMapping (value="/{id}")
		public  ModelAndView findOne (@PathVariable int id){
			Branch branch=branchRepo.findById(id).get();
			ModelAndView model = form();
			model.addObject("branch",branch);
			return model;
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


