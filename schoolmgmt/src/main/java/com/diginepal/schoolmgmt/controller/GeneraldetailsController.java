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

import com.diginepal.schoolmgmt.entities.Generaldetails;
import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.repo.GeneraldetailsRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;


@Controller
@RequestMapping("genraldetails")
public class GeneraldetailsController {


@Autowired
GeneraldetailsRepo genraldetailsRepo;

@PostMapping 
public ResponseEntity<?> save(@RequestBody Generaldetails generaldetails) {
	ResponseMessage response=new ResponseMessage();
	generaldetails=genraldetailsRepo.save(generaldetails);
	if(generaldetails==null) {
		response=Response.badrequest();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	response=Response.created();
	return new ResponseEntity<>(response, HttpStatus.CREATED);
}


@GetMapping(value="/list")
public ResponseEntity<?> findAll(){
	ResponseMessage response=new ResponseMessage();
	List<Generaldetails> list=genraldetailsRepo.findAll();
	if(list.isEmpty()) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping (value="/{id}")
public ResponseEntity<?> findOne (@PathVariable int id){
	Generaldetails genreldetails=genraldetailsRepo.findById(id).get();
	ResponseMessage response=new ResponseMessage();
	if(genreldetails==null) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(genreldetails, HttpStatus.OK);
}

@PutMapping(value="/update/{id}")
public ResponseEntity<?> update(@PathVariable int id,@RequestBody Generaldetails generaldetails) {
	ResponseMessage response=new ResponseMessage();
	Generaldetails search=genraldetailsRepo.findById(id).get();
	if(search==null) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	else {
		generaldetails.setId(id);
		generaldetails=genraldetailsRepo.save(generaldetails);
		response=Response.successful();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
@DeleteMapping(value="/delete/{id}")
public ResponseEntity<?> delete(@PathVariable int id) {
	ResponseMessage response=new ResponseMessage();
	Generaldetails generaldetails=genraldetailsRepo.findById(id).get();
	if(generaldetails==null) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	else {
	genraldetailsRepo.delete(generaldetails);
	response=Response.successful();
	return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
	
}
