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

import com.diginepal.schoolmgmt.entities.Housegroup;
import com.diginepal.schoolmgmt.entities.MotherLanguage;
import com.diginepal.schoolmgmt.entities.Section;
import com.diginepal.schoolmgmt.repo.MotherLanguageRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("motherlanguage")
public class MotherLanguageRestController {
	
	@Autowired
	MotherLanguageRepo motherLanguageRepo;
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("motherlanguage/form");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("motherlanguage/list");
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody MotherLanguage motherLanguage) {
		ResponseMessage response=new ResponseMessage();
		motherLanguage=motherLanguageRepo.save(motherLanguage);
		if(motherLanguage==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<MotherLanguage> list=motherLanguageRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		MotherLanguage motherLanguage=motherLanguageRepo.findById(id).get();
		ModelAndView model = new ModelAndView("motherlanguage/form");
		model.addObject(motherLanguage);
		return model;
	}
	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody MotherLanguage motherLanguage) {
		ResponseMessage response=new ResponseMessage();
		MotherLanguage search=motherLanguageRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			motherLanguage.setId(id);
			motherLanguage=motherLanguageRepo.save(motherLanguage);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
	

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		MotherLanguage motherlanguage=motherLanguageRepo.findById(id).get();
		if(motherlanguage==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		motherLanguageRepo.delete(motherlanguage);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
}