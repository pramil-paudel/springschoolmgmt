package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginepal.schoolmgmt.entities.Ethnicgroup;
import com.diginepal.schoolmgmt.entities.Faculty;
import com.diginepal.schoolmgmt.repo.EthnincgroupRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@Controller
@RequestMapping("ethnicgroup")
public class EthnicgroupController {
	@Autowired
	EthnincgroupRepo ethnicgroupRepo;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Ethnicgroup ethnicgroup) {
		ResponseMessage response=new ResponseMessage();
		ethnicgroup=ethnicgroupRepo.save(ethnicgroup);
		if(ethnicgroup==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<Ethnicgroup> list=ethnicgroupRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne (@PathVariable int id){
		Ethnicgroup ethnicgroup=ethnicgroupRepo.findById(id).get();
		ResponseMessage response=new ResponseMessage();
		if(ethnicgroup==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(ethnicgroup, HttpStatus.OK);
	}


	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Ethnicgroup ethnincgroup) {
		ResponseMessage response=new ResponseMessage();
		Ethnicgroup search=ethnicgroupRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			ethnincgroup.setId(id);
			ethnincgroup=ethnicgroupRepo.save(ethnincgroup);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		Ethnicgroup ethnicgroup=ethnicgroupRepo.findById(id).get();
		if(ethnicgroup==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		ethnicgroupRepo.delete(ethnicgroup);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

}
