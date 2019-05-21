package com.diginepal.schoolmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Student;
import com.diginepal.schoolmgmt.repo.StudentRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@Controller
@RequestMapping("student")
public class StudentController {
		@Autowired
		StudentRepo studentRepo;

		@GetMapping
		public ModelAndView form() 
		{
			ModelAndView model = new ModelAndView("student/form");
			return model;
		}
		
		@PostMapping 
		public String save(@ModelAttribute Student student, Model model) {//main step
			ResponseMessage response=new ResponseMessage();
			 student=studentRepo.save(student);
			if(student==null) {
				response=Response.badrequest();
			}
			response=Response.created();
			model.addAttribute("response", response);
			return "student/form"; 
		}

}
