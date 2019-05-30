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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Employee;
import com.diginepal.schoolmgmt.entities.Ethnicgroup;
import com.diginepal.schoolmgmt.repo.BranchRepo;
import com.diginepal.schoolmgmt.repo.EmployeeRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;
@CrossOrigin("*")
@Controller
@RequestMapping("employee")

public class EmployeeRestController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	BranchRepo branchRepo;
	
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("employee/form");
		model.addObject("branches", branchRepo.findAll());
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("employee/list");
	}
	
	
	@PostMapping 
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		ResponseMessage response=new ResponseMessage();
		employee=employeeRepo.save(employee);
		if(employee==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Employee> list=employeeRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping (value="/{id}")
	public ModelAndView findOne (@PathVariable int id){
		Employee employee=employeeRepo.findById(id).get();
		ModelAndView model = new ModelAndView("employee/form");
		model.addObject("branches", branchRepo.findAll());
		model.addObject(employee);
		return model;
	}


	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Employee employee) {
		ResponseMessage response=new ResponseMessage();
		Employee search=employeeRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			employee.setId(id);
			employee=employeeRepo.save(employee);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Employee employee=employeeRepo.findById(id).get();
		if(employee==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		employeeRepo.delete(employee);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}



}
