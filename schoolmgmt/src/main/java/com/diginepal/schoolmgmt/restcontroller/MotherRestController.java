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

import com.diginepal.schoolmgmt.entities.Father;
import com.diginepal.schoolmgmt.entities.Mother;
import com.diginepal.schoolmgmt.repo.MotherRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("mother")


public class MotherRestController {


		@Autowired
		MotherRepo motherRepo;

		@GetMapping(value="/new")
		public ModelAndView form() 
		{
			ModelAndView model = new ModelAndView("mother/form");
			return model;
		}

		@GetMapping
		public ModelAndView list() {
			return new ModelAndView("mother/list");
		}

		@PostMapping 
		public ResponseEntity<?> save(@RequestBody Mother mother) {
			ResponseMessage response=new ResponseMessage();
			mother=motherRepo.save(mother);
			if(mother==null) {
				response=Response.badrequest();
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			response=Response.created();
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}


		@GetMapping(value="/list")
		public ResponseEntity<?> findAll(){
			ResponseMessage response=new ResponseMessage();
			List<Mother> list=motherRepo.findAll();
			if(list.isEmpty()) {
				response=Response.resourcenotfound();
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

		@GetMapping (value="/{id}")
		public  ModelAndView findOne (@PathVariable int id){
			Mother mother=motherRepo.findById(id).get();
			ModelAndView model = new ModelAndView("mother/form");
			model.addObject(mother);
			return model;
		}
		@PutMapping(value="/update/{id}")
		public ResponseEntity<?> update(@PathVariable int id,@RequestBody Mother mother) {
			ResponseMessage response=new ResponseMessage();
			Mother search=motherRepo.findById(id).get();
			if(search==null) {
				response=Response.resourcenotfound();
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			else {
				mother.setId(id);
				mother=motherRepo.save(mother);
				response=Response.successful();
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}
		@DeleteMapping(value="/delete/{id}")
		public ResponseEntity<?> delete(@PathVariable int id) {
			ResponseMessage response=new ResponseMessage();
			Mother mother=motherRepo.findById(id).get();
			if(mother==null) {
				response=Response.resourcenotfound();
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			else {
			motherRepo.delete(mother);
			response=Response.successful();
			return new ResponseEntity<>(response,HttpStatus.OK);
			}
		}
			
		}

