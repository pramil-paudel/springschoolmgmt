package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Faculty;
import com.diginepal.schoolmgmt.repo.FacultyRepo;

@RestController
@RequestMapping("faculty")
public class FacultyController {

@Autowired
FacultyRepo facultyRepo;

@PostMapping
public void save(@RequestBody Faculty faculty) {
	facultyRepo.save(faculty);
	
}

@GetMapping
public List<Faculty> findAll(){
	return facultyRepo.findAll();
}
}
