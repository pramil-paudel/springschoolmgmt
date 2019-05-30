package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.DifferentlyAbleType;
import com.diginepal.schoolmgmt.entities.Examtype;
import com.diginepal.schoolmgmt.repo.ExamtypeRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("examtype")


public class ExamtypeRestController {
	@Autowired
	ExamtypeRepo examtypeRepo;

	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("examtype/form");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("examtype/list");
	}
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Examtype examtype) {
		ResponseMessage response=new ResponseMessage();
		examtype=examtypeRepo.save(examtype);
		if(examtype==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Examtype> list=examtypeRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		Examtype examtype=examtypeRepo.findById(id).get();
		ModelAndView model = new ModelAndView("examtype/form");
		model.addObject(examtype);
		return model;
	}


	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Examtype examtype) {
		ResponseMessage response=new ResponseMessage();
		Examtype search=examtypeRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			examtype.setId(id);
			examtype=examtypeRepo.save(examtype);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Examtype examtype=examtypeRepo.findById(id).get();
		if(examtype==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		examtypeRepo.delete(examtype);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

	
	
}
