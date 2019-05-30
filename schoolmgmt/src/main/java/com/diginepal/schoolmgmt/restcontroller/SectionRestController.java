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

import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.entities.MotherLanguage;
import com.diginepal.schoolmgmt.entities.Section;
import com.diginepal.schoolmgmt.repo.SectionRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@RestController
@RequestMapping("section")
public class SectionRestController {
	
	@Autowired
	SectionRepo sectionRepo;
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("section/form");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("section/list");
	}
	
	@PostMapping 
	public ResponseEntity<?> save(@RequestBody Section section) {
		ResponseMessage response=new ResponseMessage();
		section=sectionRepo.save(section);
		if(section==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Section> list=sectionRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		Section section=sectionRepo.findById(id).get();
		ModelAndView model = new ModelAndView("section/form");
		model.addObject(section);
		return model;
	}

	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Section section) {
		ResponseMessage response=new ResponseMessage();
		Section search=sectionRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			section.setId(id);
			section=sectionRepo.save(section);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Section section=sectionRepo.findById(id).get();
		if(section==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		sectionRepo.delete(section);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

}
