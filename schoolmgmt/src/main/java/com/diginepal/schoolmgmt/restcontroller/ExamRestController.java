package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.DifferentlyAbleType;
import com.diginepal.schoolmgmt.entities.Exam;
import com.diginepal.schoolmgmt.repo.AcademicdatesRepo;
import com.diginepal.schoolmgmt.repo.ExamRepo;
import com.diginepal.schoolmgmt.repo.ExamtypeRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("exam")


public class ExamRestController {
@Autowired
ExamRepo examRepo;

@Autowired
AcademicdatesRepo academicdatesRepo;

@Autowired
ExamtypeRepo examtypeRepo;



@GetMapping(value="/new")
public ModelAndView form() 
{
	
		ModelAndView model = new ModelAndView("exam/form");
		model.addObject("academicdates", academicdatesRepo.findAll());
		model.addObject("examtypes", examtypeRepo.findAll());
		return model;
	}

@GetMapping
public ModelAndView list() {
	return new ModelAndView("exam/list");
}


@PostMapping
public ResponseEntity<?> save(@RequestBody Exam exam) {
	ResponseMessage response=new ResponseMessage();
	exam=examRepo.save(exam);
	if(exam==null) {
		response=Response.badrequest();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	response=Response.created();
	return new ResponseEntity<>(response, HttpStatus.CREATED);
}

@GetMapping(value="/list")
public ResponseEntity<?> findAll(){
	ResponseMessage response=new ResponseMessage();
	List<Exam> list=examRepo.findAll();
	if(list.isEmpty()) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping (value="/{id}")
public  ModelAndView findOne (@PathVariable int id){
	Exam exam=examRepo.findById(id).get();
	ModelAndView model = new ModelAndView("exam/form");
	model.addObject(exam);
	return model;
}

@PutMapping(value = "/update/{id}")
public ResponseEntity<?> update(@PathVariable int id,@RequestBody Exam exam) {
	ResponseMessage response=new ResponseMessage();
	Exam search=examRepo.findById(id).get();
	if(search==null) {
		response=Response.resourcenotfound();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	else {
		exam.setId(id);
		exam=examRepo.save(exam);
		response=Response.successful();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

}
