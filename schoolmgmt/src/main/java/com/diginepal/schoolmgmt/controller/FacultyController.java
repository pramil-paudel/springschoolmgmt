package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Company;
import com.diginepal.schoolmgmt.entities.DifferentlyAbleType;
import com.diginepal.schoolmgmt.entities.Faculty;
import com.diginepal.schoolmgmt.repo.FacultyRepo;

@RestController
@RequestMapping("faculty")
public class FacultyController {

@Autowired
FacultyRepo facultyRepo;

@PostMapping (value="/save")
public Faculty save(@RequestBody Faculty faculty) {
	return facultyRepo.save(faculty);
	
}

@GetMapping (value="/list")
public List<Faculty> findAll(){
	return facultyRepo.findAll();
}

@GetMapping (value="/{id}")
public Faculty findOne (@PathVariable int id){
	return facultyRepo.findById(id).get();
}

@PutMapping(value="/update/{id}")
public Faculty update(@PathVariable int id,@RequestBody Faculty faculty) {
	faculty.setId(id);
	return facultyRepo.save(faculty);
}
@DeleteMapping(value="/delete/{id}")
public void delete(@PathVariable int id) {
	Faculty faculty=facultyRepo.findById(id).get();
	facultyRepo.delete(faculty);
}

}
