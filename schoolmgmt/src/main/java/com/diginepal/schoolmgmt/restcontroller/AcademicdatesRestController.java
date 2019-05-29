package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

import com.diginepal.schoolmgmt.entities.Academicdates;
import com.diginepal.schoolmgmt.repo.AcademicdatesRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@RestController
@RequestMapping("academicdates")
public class AcademicdatesRestController {
	
	@Autowired 
	AcademicdatesRepo academicdatesRepo;
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("academicdates/form");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("academicdates/list");
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Academicdates academicdates) {
		ResponseMessage response=new ResponseMessage();
		academicdates=academicdatesRepo.save(academicdates);
		if(academicdates==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/list")
	public List<Academicdates> findAll(Model model){
		List<Academicdates> list=academicdatesRepo.findAll();
		model.addAttribute("academicdates", list);
		return list;
	}
	
	
	@GetMapping(value="/{id}")
	public ModelAndView findOne(@PathVariable int id ){
		ModelAndView model = new ModelAndView("academicdates/form");
		Academicdates academicdates=academicdatesRepo.findById(id).get();
		model.addObject("academicdates", academicdates);
		return model;
			
		}
		
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Academicdates academicdates) {
		ResponseMessage response=new ResponseMessage();
		Academicdates search=academicdatesRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			academicdates.setId(id);
			academicdates=academicdatesRepo.save(academicdates);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Academicdates academicdates=academicdatesRepo.findById(id).get();
		if(academicdates==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		academicdatesRepo.delete(academicdates);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
}
