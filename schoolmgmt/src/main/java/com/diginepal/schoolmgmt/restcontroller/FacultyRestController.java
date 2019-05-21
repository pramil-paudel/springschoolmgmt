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

import com.diginepal.schoolmgmt.entities.Faculty;
import com.diginepal.schoolmgmt.entities.Generaldetails;
import com.diginepal.schoolmgmt.repo.FacultyRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("faculty")
public class FacultyRestController {

@Autowired
FacultyRepo facultyRepo;

@GetMapping(value="/new")
public ModelAndView form() 
{
	
		ModelAndView model = new ModelAndView("faculty/form");
		return model;
	}

@GetMapping
public ModelAndView list() {
	return new ModelAndView("faculty/list");
}


@PostMapping 
public ResponseEntity<?> save(@RequestBody Faculty faculty) {
	ResponseMessage response=new ResponseMessage();
	faculty=facultyRepo.save(faculty);
	if(faculty==null) {
		response=Response.badrequest();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	response=Response.created();
	return new ResponseEntity<>(response, HttpStatus.CREATED);
}

@GetMapping(value="/list")
public ResponseEntity<?> findAll(){
	ResponseMessage response=new ResponseMessage();
	List<Faculty> list=facultyRepo.findAll();
	if(list.isEmpty()) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping (value="/{id}")
public ResponseEntity<?> findOne (@PathVariable int id){
	Faculty faculty=facultyRepo.findById(id).get();
	ResponseMessage response=new ResponseMessage();
	if(faculty==null) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(faculty, HttpStatus.OK);
}

@PutMapping(value="/update/{id}")
public ResponseEntity<?> update(@PathVariable int id,@RequestBody Faculty faculty) {
	ResponseMessage response=new ResponseMessage();
	Faculty search=facultyRepo.findById(id).get();
	if(search==null) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	else {
		faculty.setId(id);
		faculty=facultyRepo.save(faculty);
		response=Response.successful();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
@DeleteMapping(value="/delete/{id}")
public ResponseEntity<?> delete(@PathVariable int id) {
	ResponseMessage response=new ResponseMessage();
	Faculty faculty=facultyRepo.findById(id).get();
	if(faculty==null) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	else {
	facultyRepo.delete(faculty);
	response=Response.successful();
	return new ResponseEntity<>(response,HttpStatus.OK);
	}
}

}
