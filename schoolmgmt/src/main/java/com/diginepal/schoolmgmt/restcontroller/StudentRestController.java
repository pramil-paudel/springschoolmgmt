package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Exam;
import com.diginepal.schoolmgmt.entities.Student;
import com.diginepal.schoolmgmt.repo.FatherRepo;
import com.diginepal.schoolmgmt.repo.LocalguardainRepo;
import com.diginepal.schoolmgmt.repo.MotherLanguageRepo;
import com.diginepal.schoolmgmt.repo.MotherRepo;
import com.diginepal.schoolmgmt.repo.StudentRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@RestController
@RequestMapping("student")
public class StudentRestController {
	@Autowired
	StudentRepo studentRepo;
	
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("student/form");
		model.addObject("student", new Student());
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("student/list");
	}
	

	@PostMapping 
	public ResponseEntity<?> save(@RequestBody Student student) {
		ResponseMessage response=new ResponseMessage();
		student=studentRepo.save(student);
		if(student==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping(value="/list")
	public ResponseEntity<?> findAll() {
		ResponseMessage response = new ResponseMessage();
		List<Student> list = studentRepo.findAll();
		if (list.isEmpty()) {
			response = Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		Student student=studentRepo.findById(id).get();
		ModelAndView model = form();
		model.addObject("student",student);
		return model;
	}

	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Student student) {
		ResponseMessage response=new ResponseMessage();
		Student search=studentRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			student.setId(id);
			student=studentRepo.save(student);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response = new ResponseMessage();
		Student student = studentRepo.findById(id).get();
		if (student == null) {
			response = Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {
			studentRepo.delete(student);
			response = Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

}
