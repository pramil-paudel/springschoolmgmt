package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.diginepal.schoolmgmt.entities.Subjects;
import com.diginepal.schoolmgmt.repo.SubjectsRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;


@CrossOrigin("*")
@RestController
@RequestMapping("subjects")
public class SubjectsRestController {
	@Autowired
	SubjectsRepo subjectsRepo;
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("subjects/form");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("subjects/list");
	}

	
	@PostMapping 
	public ResponseEntity<?> save(@RequestBody Subjects subjects) {
		ResponseMessage response=new ResponseMessage();
		subjects=subjectsRepo.save(subjects);
		if(subjects==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping (value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Subjects> list=subjectsRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping (value="/{id}")
	public ResponseEntity<?> findOne (@PathVariable int id){
		Subjects subjects=subjectsRepo.findById(id).get();
		ResponseMessage response=new ResponseMessage();
		if(subjects==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(subjects, HttpStatus.OK);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Subjects subjects) {
		ResponseMessage response=new ResponseMessage();
		Subjects search=subjectsRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			subjects.setId(id);
			subjects=subjectsRepo.save(subjects);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Subjects subjects=subjectsRepo.findById(id).get();
		if(subjects==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		subjectsRepo.delete(subjects);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	
	
}
