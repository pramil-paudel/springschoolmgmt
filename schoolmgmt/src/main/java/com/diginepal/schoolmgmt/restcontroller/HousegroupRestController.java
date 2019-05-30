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
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.entities.Housegroup;
import com.diginepal.schoolmgmt.entities.MotherLanguage;
import com.diginepal.schoolmgmt.repo.HousegroupRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("housegroup")
public class HousegroupRestController {

	@Autowired
	HousegroupRepo housegroupRepo;
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("housegroup/form");
		return model;
	}
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("housegroup/list");
	}
	
	@PostMapping 
	public ResponseEntity<?> save(@RequestBody Housegroup housegroup) {
		ResponseMessage response=new ResponseMessage();
		housegroup=housegroupRepo.save(housegroup);
		if(housegroup==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Housegroup> list=housegroupRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		Housegroup housegroup=housegroupRepo.findById(id).get();
		ModelAndView model = new ModelAndView("housegroup/form");
		model.addObject(housegroup);
		return model;
	}
	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Housegroup housegroup) {
		ResponseMessage response=new ResponseMessage();
		Housegroup search=housegroupRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			housegroup.setId(id);
			housegroup=housegroupRepo.save(housegroup);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Housegroup housegroup=housegroupRepo.findById(id).get();
		if(housegroup==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		housegroupRepo.delete(housegroup);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
}
