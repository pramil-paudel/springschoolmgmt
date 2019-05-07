package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Generaldetails;
import com.diginepal.schoolmgmt.repo.GeneraldetailsRepo;


@RestController
@RequestMapping("genraldetails")
public class GeneraldetailsController {


@Autowired
GeneraldetailsRepo genraldetailsRepo;

@PostMapping (value="/save")
public Generaldetails save(@RequestBody Generaldetails generaldetails) {
	return genraldetailsRepo.save(generaldetails);
	
}

@GetMapping (value="/list")
public List<Generaldetails> findAll(){
	return genraldetailsRepo.findAll();
}

@GetMapping (value="/{id}")
public Generaldetails findOne (@PathVariable int id){
	return genraldetailsRepo.findById(id).get();
}

@PutMapping(value="/update/{id}")
public Generaldetails update(@PathVariable int id,@RequestBody Generaldetails genraldetails) {
	genraldetails.setId(id);
	return genraldetailsRepo.save(genraldetails);
}
@DeleteMapping(value="/delete/{id}")
public void delete(@PathVariable int id) {
	Generaldetails genraldetails=genraldetailsRepo.findById(id).get();
	genraldetailsRepo.delete(genraldetails);
}
	
}
