package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Student;
import com.diginepal.schoolmgmt.entities.Subjects;
import com.diginepal.schoolmgmt.repo.StudentRepo;
import com.diginepal.schoolmgmt.repo.SubjectsRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("studentsubjects")
public class StudentSubjectsRestController {
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	SubjectsRepo subjectsRepo;
	
	@ModelAttribute
	public void models(Model model) {
		model.addAttribute("students", studentRepo.findAll());
		model.addAttribute("subjects", subjectsRepo.findAll());
	}
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("student_subjects/form");
		model.addObject("student", new Student());
		return model;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> list(@PathVariable int id) 
	{
		ResponseMessage response = new ResponseMessage();
		List<Subjects> list = studentRepo.findById(id).get().getSubjects();
		if (list.isEmpty()) {
			response = Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	

}
