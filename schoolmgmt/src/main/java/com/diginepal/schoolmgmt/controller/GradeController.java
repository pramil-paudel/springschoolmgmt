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

import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.entities.Housegroup;
import com.diginepal.schoolmgmt.repo.GradeRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;



@Controller
@RequestMapping("grade")
public class GradeController {
	
	@Autowired
	GradeRepo gradeRepo;
	
	@PostMapping 
	public ResponseEntity<?> save(@RequestBody Grade grade) {
		ResponseMessage response=new ResponseMessage();
		grade=gradeRepo.save(grade);
		if(grade==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Grade> list=gradeRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping (value="/{id}")
	public ResponseEntity<?> findOne (@PathVariable int id){
		Grade grade=gradeRepo.findById(id).get();
		ResponseMessage response=new ResponseMessage();
		if(grade==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(grade, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Grade grade) {
		ResponseMessage response=new ResponseMessage();
		Grade search=gradeRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			grade.setId(id);
			grade=gradeRepo.save(grade);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Grade grade=gradeRepo.findById(id).get();
		if(grade==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		gradeRepo.delete(grade);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

}
