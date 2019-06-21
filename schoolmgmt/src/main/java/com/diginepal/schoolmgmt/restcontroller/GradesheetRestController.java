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

import com.diginepal.schoolmgmt.entities.Gradesheet;
import com.diginepal.schoolmgmt.repo.GradesheetRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("gradesheet")
public class GradesheetRestController {

	@Autowired
	GradesheetRepo gradesheetRepo;
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("gradesheet/form");
		return model;
	}
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("gradesheet/list");
	}

	
	@PostMapping 
	public ResponseEntity<?> save(@RequestBody Gradesheet gradesheet) {
		ResponseMessage response=new ResponseMessage();
		gradesheet=gradesheetRepo.save(gradesheet);
		if(gradesheet==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Gradesheet> list=gradesheetRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		Gradesheet gradesheet=gradesheetRepo.findById(id).get();
		ModelAndView model = new ModelAndView("gradesheet/form");
		model.addObject(gradesheet);
		return model;
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Gradesheet gradesheet) {
		ResponseMessage response=new ResponseMessage();
		Gradesheet search=gradesheetRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			gradesheet.setId(id);
			gradesheet=gradesheetRepo.save(gradesheet);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Gradesheet gradesheet=gradesheetRepo.findById(id).get();
		if(gradesheet==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		gradesheetRepo.delete(gradesheet);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

}

	
	

