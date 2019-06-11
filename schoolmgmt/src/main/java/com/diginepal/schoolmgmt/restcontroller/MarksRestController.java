package com.diginepal.schoolmgmt.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Marks;
import com.diginepal.schoolmgmt.repo.AcademicdatesRepo;
import com.diginepal.schoolmgmt.repo.GradeRepo;
import com.diginepal.schoolmgmt.repo.MarksRepo;
import com.diginepal.schoolmgmt.repo.SectionRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;
import com.diginepal.schoolmgmt.service.MarksService;

@CrossOrigin("*")
@Controller
@RequestMapping("marks")
public class MarksRestController {

	@Autowired
	MarksRepo marksRepo;

	@Autowired
	AcademicdatesRepo academicdatesRepo;
	
	@Autowired
	GradeRepo gradeRepo;
	
	@Autowired
	SectionRepo sectionRepo;
	
	@Autowired MarksService marksService;
	

	@ModelAttribute
	public void models(Model model) {
		model.addAttribute("academicdates",academicdatesRepo.findAll());
		model.addAttribute("section",sectionRepo.findAll());
		model.addAttribute("grade",gradeRepo.findAll());
	}

	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("marksentry/form");
		return model;
	}

	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("marksentry/list");
	}

	@PostMapping 
	public ResponseEntity<?> save(@RequestBody List<Marks> markslist) {
		ResponseMessage response=new ResponseMessage();
		List<Marks> list=new ArrayList<Marks>();
		list=marksService.save(markslist);
		if(markslist.size()!=list.size()) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}


	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Marks> list=marksRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping(value="/exam/{examid}/student/{studentid}")
	public ResponseEntity<?>  findByExamIdAndStudentId(@PathVariable int examid, @PathVariable int studentid){
		ResponseMessage response=new ResponseMessage();
		List<Marks> list = marksRepo.findByExamIdAndStudentId(examid, studentid);
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	

	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		Marks marks=marksRepo.findById(id).get();
		ModelAndView model = new ModelAndView("marksentry/form");
		model.addObject("academicdates",academicdatesRepo.findAll());
		model.addObject("grade",gradeRepo.findAll());
		model.addObject("section",sectionRepo.findAll());
		model.addObject(marks);
		return model;
	}

	@PutMapping(value="/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Marks marks) {
		ResponseMessage response=new ResponseMessage();
		Marks search=marksRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			marks.setId(id);
			marks=marksRepo.save(marks);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Marks marks=marksRepo.findById(id).get();
		if(marks==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		marksRepo.delete(marks);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

}
